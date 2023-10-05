package com.example.myapplication.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.domain.model.FavoriteDrink

@Database(entities = [ DrinkInfoEntity::class, FavoriteDrink::class], version = 8)
abstract class AppDatabase : RoomDatabase() {
    abstract fun menuDao(): DrinkDao

    companion object {
        const val DATABASE_NAME = "surf_pet_database"
    }
}