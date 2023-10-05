package com.example.myapplication.di

import android.app.Application
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.example.myapplication.data.repository.MainRepositoryImpl
import com.example.myapplication.data.source.local.AppDatabase
import com.example.myapplication.data.source.local.DrinkInfoEntity
import com.example.myapplication.data.source.remote.Constants
import com.example.myapplication.data.source.remote.DrinkRemoteMediator
import com.example.myapplication.data.source.remote.DrinksApi
import com.example.myapplication.data.source.remote.SimpleApi
import com.example.myapplication.domain.model.DrinkInfoRemote
import com.example.myapplication.domain.repository.MainRepository
import com.example.myapplication.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app.applicationContext,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.DRINKS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideSimpleApi(retrofit: Retrofit): DrinksApi {
        return retrofit.create(DrinksApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepositoryDatabase(db: AppDatabase, drinksApi: DrinksApi): MainRepository {
        return MainRepositoryImpl(db.menuDao(), drinksApi)
    }

    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @Singleton
    fun provideDrinkPager(drinksDb: AppDatabase, drinksApi: DrinksApi): Pager<Int, DrinkInfoEntity> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = DrinkRemoteMediator(
                drinksDb = drinksDb,
                drinksApi = drinksApi
            ),
            pagingSourceFactory = {
                drinksDb.menuDao().pagingSource()
            }
        )
    }

    @Provides
    @Singleton
    fun provideMenuUseCases(mainRepository: MainRepository): MainUseCases {
        return MainUseCases(
            getDrinksInfoRemote = GetDrinksInfoRemote(mainRepository),
            getFavoriteDrink = GetFavoriteDrink(mainRepository),
            insertFavoriteDrink = InsertFavoriteDrink(mainRepository),
            deleteFavoriteDrink = DeleteFavoriteDrink(mainRepository),
        )
    }
}