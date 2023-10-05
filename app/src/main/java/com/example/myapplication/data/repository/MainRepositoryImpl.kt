package com.example.myapplication.data.repository

import com.example.myapplication.data.source.local.DrinkDao
import com.example.myapplication.data.source.remote.DrinksApi
import com.example.myapplication.domain.model.DrinkInfoRemote
import com.example.myapplication.domain.model.EntityPictureInfo
import com.example.myapplication.domain.model.FavoriteDrink
import com.example.myapplication.domain.repository.MainRepository

class MainRepositoryImpl(
    private val drinkDao: DrinkDao,
    private var drinksApi: DrinksApi,
) : MainRepository {

    override suspend fun getDrinksInfoRemote(page: Int): List<DrinkInfoRemote> {
        val map = mutableMapOf<String, Int>().also {
            it["page"] = page
        }
        return drinksApi.getDrinksInfo(map)
    }

    override suspend fun getFavoriteDrink(): List<FavoriteDrink> {
        return drinkDao.getFavoriteDrinks()
    }

    override fun insertFavoriteDrink(favoriteDrink: FavoriteDrink) {
        drinkDao.insertFavoriteDrink(favoriteDrink)
    }

    override fun deleteFavoriteDrink(id: String) {
        drinkDao.deleteFavoriteDrink(id)
    }

    override fun deleteAllMenuItems() {
        drinkDao.deleteAllMenuItems()
    }

}