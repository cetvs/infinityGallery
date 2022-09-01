package com.example.di

import android.app.Application
import androidx.room.Room
import com.example.data.repository.MainRepositoryImpl
import com.example.data.source.local.AppDatabase
import com.example.data.source.remote.Constants
import com.example.data.source.remote.SimpleApi
import com.example.domain.repository.MainRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataModule {
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
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideSimpleApi(retrofit: Retrofit): SimpleApi {
        return retrofit.create(SimpleApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepositoryDatabase(db: AppDatabase, simpleApi: SimpleApi): MainRepository {
        return MainRepositoryImpl(db.menuDao(), simpleApi)
    }
}