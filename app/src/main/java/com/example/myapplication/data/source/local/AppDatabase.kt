package com.example.myapplication.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.domain.model.PictureInfo
import com.example.myapplication.domain.model.ProfileInfo

@Database(entities = [PictureInfo::class, ProfileInfo::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun menuDao(): AppDao

    companion object {
        const val DATABASE_NAME = "surf_pet_database"
    }
}