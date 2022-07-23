package com.example.myapplication.data.repository

import com.example.myapplication.data.source.local.AppDao
import com.example.myapplication.data.source.remote.SimpleApi
import com.example.myapplication.domain.model.PictureInfo
import com.example.myapplication.domain.model.ProfileInfo
import com.example.myapplication.domain.model.ProfileRequestBody
import com.example.myapplication.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow

class MainRepositoryImpl(
    private val appDao: AppDao,
    private var simpleApi: SimpleApi
) : MainRepository {
    override suspend fun getProfileInfo(profileRequestBody: ProfileRequestBody): ProfileInfo {
        return simpleApi.getProfileInfo(profileRequestBody)
    }

    override suspend fun getPictureInfo(token: String): List<PictureInfo> =
        simpleApi.getPictureInfo("Token $token")

    override suspend fun postAuthLogout(token: String) {
        simpleApi.postAuthLogout("Token $token")
    }

    override fun getLocalPictureInfo(): Flow<List<PictureInfo>> =
        appDao.getPictureInfo()

    override fun getLocalProfileInfo(): ProfileInfo? =
        appDao.getProfileInfo()

    override fun insertProfileInfo(profileInfo: ProfileInfo) {
        appDao.insertProfileInfo(profileInfo)
    }

    override fun insertPicturesInfo(picturesInfo: List<PictureInfo>) {
        appDao.insertPictureInfo(picturesInfo)
    }

    override fun deleteProfileInfo(){
        appDao.deleteProfileInfo()
    }

    override fun deleteAllMenuItems() {
        appDao.deleteAllMenuItems()
    }

}