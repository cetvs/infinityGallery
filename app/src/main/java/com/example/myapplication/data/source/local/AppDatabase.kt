package com.example.myapplication.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.domain.model.PictureInfo

@Database(entities = [PictureInfo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun menuDao(): AppDao

    companion object {
        const val DATABASE_NAME = "surf_pet_database"
    }
}