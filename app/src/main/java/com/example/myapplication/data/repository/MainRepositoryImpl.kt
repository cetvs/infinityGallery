package com.example.myapplication.data.repository

import com.example.myapplication.data.source.local.AppDao
import com.example.myapplication.domain.model.PictureInfo
import com.example.myapplication.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow

class MainRepositoryImpl(private val appDao: AppDao) : MainRepository {
    override fun getPictureInfo(): Flow<List<PictureInfo>> {
        return appDao.getMenuItems()
    }

    override fun addFavoritePictureInfo(pictureInfo: PictureInfo) {
        appDao.insertMenuItem(pictureInfo)
    }
}