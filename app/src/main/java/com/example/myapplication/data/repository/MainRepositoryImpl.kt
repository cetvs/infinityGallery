package com.example.myapplication.data.repository

import com.example.myapplication.data.source.local.AppDao
import com.example.myapplication.data.source.remote.SimpleApi
import com.example.myapplication.domain.model.PictureInfo
import com.example.myapplication.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow

class MainRepositoryImpl(
    private val appDao: AppDao,
    private var simpleApi: SimpleApi
) : MainRepository {
    override suspend fun getPictureInfo(): List<PictureInfo> =
        simpleApi.getPictureInfo()

    override fun getLocalPictureInfo(): Flow<List<PictureInfo>> {
        return appDao.getPictureInfo()
    }

    override fun insertPicturesInfo(pictureInfo: PictureInfo) {
        appDao.insertPictureInfo(pictureInfo)
    }
}