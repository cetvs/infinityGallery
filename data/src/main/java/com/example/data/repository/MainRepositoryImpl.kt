package com.example.data.repository

import com.example.data.source.local.AppDao
import com.example.data.source.remote.SimpleApi
import com.example.domain.model.EntityPictureInfo
import com.example.domain.model.PictureInfo
import com.example.domain.model.ProfileInfo
import com.example.domain.repository.MainRepository
import com.example.myapplication.domain.model.ProfileRequestBody
import kotlinx.coroutines.flow.Flow

class MainRepositoryImpl(
    private val appDao: AppDao,
    private var simpleApi: SimpleApi
) : MainRepository {
    override suspend fun getProfileInfo(profileRequestBody: ProfileRequestBody): ProfileInfo? {
        return simpleApi.getProfileInfo(profileRequestBody)
    }

    override suspend fun getPictureInfo(token: String): List<PictureInfo> =
        simpleApi.getPictureInfo("Token $token")

    override suspend fun postAuthLogout(token: String) {
        simpleApi.postAuthLogout("Token $token")
    }

    override fun getLocalPictureInfo(): Flow<List<EntityPictureInfo>> =
        appDao.getPictureInfo()

    override fun getLocalProfileInfo(): ProfileInfo? =
        appDao.getProfileInfo()

    override fun insertProfileInfo(profileInfo: ProfileInfo) {
        appDao.insertProfileInfo(profileInfo)
    }

    override fun insertPicturesInfo(picturesInfo: List<EntityPictureInfo>) {
        appDao.insertPicturesInfo(picturesInfo)
    }

    override fun deleteProfileInfo(){
        appDao.deleteProfileInfo()
    }

    override fun deleteAllMenuItems() {
        appDao.deleteAllMenuItems()
    }

}