package com.example.myapplication.data.repository

import com.example.myapplication.data.source.local.AppDao
import com.example.myapplication.data.source.remote.SimpleApi
import com.example.myapplication.domain.model.EntityPictureInfo
import com.example.myapplication.domain.model.PictureInfo
import com.example.myapplication.domain.model.ProfileInfo
import com.example.myapplication.domain.model.ProfileRequestBody
import com.example.myapplication.domain.repository.MainRepository

class MockMainRepositoryImpl(
    private val appDao: AppDao,
    private var simpleApi: SimpleApi,
) : MainRepository {
    override suspend fun getProfileInfo(profileRequestBody: ProfileRequestBody): ProfileInfo? {
        return simpleApi.getProfileInfo(profileRequestBody)
    }

    override suspend fun getPictureInfo(token: String): List<PictureInfo> {
        return pictureInfoResponse
    }

    override suspend fun postAuthLogout(token: String) {
        simpleApi.postAuthLogout("Token $token")
    }

    override fun getLocalPictureInfo(): List<EntityPictureInfo> {
        return appDao.getPictureInfo()
    }

    override fun getLocalProfileInfo(): ProfileInfo? {
        return appDao.getProfileInfo()
    }

    override fun insertProfileInfo(profileInfo: ProfileInfo) {
        appDao.insertProfileInfo(profileInfo)
    }

    override fun insertPicturesInfo(picturesInfo: List<EntityPictureInfo>) {
        appDao.insertPicturesInfo(picturesInfo)
    }

    override fun deleteProfileInfo() {
        appDao.deleteProfileInfo()
    }

    override fun deletePictureInfo(id: String){
        appDao.deletePicturesInfo(id)
    }

    override fun deleteAllMenuItems() {
        appDao.deleteAllMenuItems()
    }

    companion object {
        private val pictureInfo = PictureInfo(
            id = "1",
            title = "Первый день в Surf",
            content = "Для бариста и посетителей кофеен специальные кружки для кофе — это ещё один способ проконтролировать вкус напитка и приготовить его именно так, как нравится вам.\n" +
                    "\n" +
                    "Теперь, кроме регулировки экстракции, настройки помола, времени заваривания и многого что помогает выделять нужные характеристики кофе, вы сможете выбрать и кружку для кофе в зависимости от сорта.",
            photoUrl = "https://www.nespresso.com/ncp/res/uploads/recipes/nespresso-recipes-Granola-coffee.jpg",
            publicationDate = 234199434
        )

        private val pictureInfoResponse = listOf(
            pictureInfo,
            pictureInfo.copy(id = "2", title = "Самый милый корги"),
            pictureInfo.copy(id = "3", title = "Печенья которые приг..."),
            pictureInfo.copy(id = "4", title = "Чашечка свежего кофе"),
            pictureInfo.copy(id = "5", title = "Карта в поезде"),
        )
    }
}