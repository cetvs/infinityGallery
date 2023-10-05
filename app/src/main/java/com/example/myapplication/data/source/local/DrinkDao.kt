package com.example.myapplication.data.source.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.domain.model.EntityPictureInfo
import com.example.myapplication.domain.model.FavoriteDrink

@Dao
interface DrinkDao {

    @Query("SELECT * FROM drinkInfo")
    fun pagingSource(): PagingSource<Int, DrinkInfoEntity>

    @Insert()
    fun insertDrinksInfo(entityDrinksInfo: List<DrinkInfoEntity>)

    @Query("SELECT * FROM favoriteDrinks")
    fun getFavoriteDrinks(): List<FavoriteDrink>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavoriteDrink(favoriteDrink: FavoriteDrink)

    @Query("DELETE FROM favoriteDrinks WHERE id = :deleteId")
    fun deleteFavoriteDrink(deleteId: String)

    @Query("DELETE FROM drinkInfo")
    fun deleteAllMenuItems()

}