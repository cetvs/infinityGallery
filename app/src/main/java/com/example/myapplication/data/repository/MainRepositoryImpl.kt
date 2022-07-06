package com.example.myapplication.data.repository

import android.util.Log
import com.example.myapplication.data.source.local.AppDao
import com.example.myapplication.data.source.remote.SimpleApi
import com.example.myapplication.domain.model.PictureInfo
import com.example.myapplication.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow

class MainRepositoryImpl(
    private val appDao: AppDao,
    private var simpleApi: SimpleApi
) : MainRepository {
    override suspend fun getPictureInfo(){
        val flow = simpleApi.getPictureInfo()
        flow.collect { Log.v("APIINFO", it.toString()) }

    }

    override fun getFavoritePictureInfo(): Flow<List<PictureInfo>> {
        return appDao.getPictureInfo()
    }

//    override fun getPictureInfo(): Flow<List<PictureInfo>> {
//        return appDao.getPictureInfo()
//    }

    override fun addFavoritePictureInfo(pictureInfo: PictureInfo) {
        appDao.insertPictureInfo(pictureInfo)
    }
}