package com.example.domain.di

import com.example.domain.repository.MainRepository
import com.example.domain.usecase.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {
    @Provides
    @Singleton
    fun provideMenuUseCases(mainRepository: MainRepository): MainUseCases {
        return MainUseCases(
            getProfileInfo = GetProfileInfo(mainRepository),
            getPictureInfo = GetPictureInfo(mainRepository),
            postAuthLogout = PostAuthLogout(mainRepository),
            getLocalProfileInfo = GetLocalProfileInfo(mainRepository),
            getLocalPictureInfo = GetLocalPictureInfo(mainRepository),
            insertProfileInfo = InsertProfileInfo(mainRepository),
            insertPicturesInfo = InsertPicturesInfo(mainRepository),
            deleteProfileInfo = DeleteProfileInfo(mainRepository),
            deleteAllMenuItems = DeleteAllMenuItems(mainRepository),
        )
    }
}