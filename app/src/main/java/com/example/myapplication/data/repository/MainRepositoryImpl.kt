package com.example.myapplication.data.repository

import com.example.myapplication.data.source.local.AppDao
import com.example.myapplication.data.source.remote.DrinksApi
import com.example.myapplication.domain.model.DrinkInfoRemote
import com.example.myapplication.domain.model.EntityPictureInfo
import com.example.myapplication.domain.model.FavoriteDrink
import com.example.myapplication.domain.model.ProfileInfo
import com.example.myapplication.domain.repository.MainRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class MainRepositoryImpl(
    private val appDao: AppDao,
    private var drinksApi: DrinksApi,
) : MainRepository {

    override suspend fun getDrinksInfoRemote(page: Int): List<DrinkInfoRemote> {
        val map = mutableMapOf<String, Int>().also {
            it["page"] = page
        }
        return drinksApi.getDrinksInfo(map)
    }

    override suspend fun getFavoriteDrink(): List<FavoriteDrink> {
        return appDao.getFavoriteDrinks()
    }

    override fun insertFavoriteDrink(favoriteDrink: FavoriteDrink) {
        appDao.insertFavoriteDrink(favoriteDrink)
    }

    override fun deleteFavoriteDrink(id: String) {
        appDao.deleteFavoriteDrink(id)
    }

    override fun getLocalPictureInfo(): List<EntityPictureInfo> =
        appDao.getPictureInfo()

    override fun insertPicturesInfo(picturesInfo: List<EntityPictureInfo>) {
        appDao.insertPicturesInfo(picturesInfo)
    }


    override fun deletePictureInfo(id: String){
        appDao.deletePicturesInfo(id)
    }

    override fun deleteAllMenuItems() {
        appDao.deleteAllMenuItems()
    }

}