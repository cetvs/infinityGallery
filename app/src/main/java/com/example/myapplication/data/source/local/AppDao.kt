package com.example.myapplication.data.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.domain.model.PictureInfo
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {
    @Query("SELECT * FROM pictureInfo")
    fun getMenuItems(): Flow<List<PictureInfo>>

    @Insert
    fun insertMenuItem(pictureInfo: PictureInfo)
}