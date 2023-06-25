package com.example.myapplication.data.source.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.domain.model.EntityPictureInfo
import com.example.myapplication.domain.model.FavoriteDrink

@Dao
interface AppDao {

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

    @Insert
    fun insertPicturesInfo(entityPictureInfo: List<EntityPictureInfo>)

    @Insert
    fun updateFavoritePictureInfo(entityPictureInfo: EntityPictureInfo)

    @Query("DELETE FROM pictureInfo WHERE id = :pictureId")
    fun deletePicturesInfo(pictureId: String)

    @Query("DELETE FROM drinkInfo")
    fun deleteAllMenuItems()

    @Query("SELECT * FROM pictureInfo")
    fun getPictureInfo(): List<EntityPictureInfo>

}