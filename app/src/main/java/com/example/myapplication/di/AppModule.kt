package com.example.myapplication.di

import android.app.Application
import androidx.room.Room
import com.example.myapplication.data.repository.MainRepositoryImpl
import com.example.myapplication.data.source.local.AppDatabase
import com.example.myapplication.domain.repository.MainRepository
import com.example.myapplication.domain.usecase.AddFavoritePictureInfo
import com.example.myapplication.domain.usecase.GetPictureInfo
import com.example.myapplication.domain.usecase.MainUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFoodDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app.applicationContext,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideRepositoryDatabase(db: AppDatabase): MainRepository {
        return MainRepositoryImpl(db.menuDao())
    }

    @Provides
    @Singleton
    fun provideMenuUseCases(menuRepository: MainRepository): MainUseCases {
        return MainUseCases(
            getPictureInfo = GetPictureInfo(menuRepository),
            addFavoritePictureInfo = AddFavoritePictureInfo(menuRepository),
        )
    }
}