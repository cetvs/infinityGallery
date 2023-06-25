package com.example.myapplication.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.domain.model.EntityPictureInfo
import com.example.myapplication.domain.model.FavoriteDrink

@Database(entities = [EntityPictureInfo::class, DrinkInfoEntity::class, FavoriteDrink::class], version = 6)
abstract class AppDatabase : RoomDatabase() {
    abstract fun menuDao(): AppDao

    companion object {
        const val DATABASE_NAME = "surf_pet_database"
    }
}