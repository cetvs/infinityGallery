package com.example.myapplication.domain.repository

import com.example.myapplication.domain.model.*

interface MainRepository {
    suspend fun getDrinksInfoRemote(page: Int): List<DrinkInfoRemote>
    suspend fun getFavoriteDrink(): List<FavoriteDrink>
    fun insertFavoriteDrink(favoriteDrink: FavoriteDrink)
    fun deleteFavoriteDrink(id: String)
    fun deleteAllMenuItems()
}