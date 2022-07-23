package com.example.myapplication.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.domain.model.PictureInfo
import com.example.myapplication.domain.model.ProfileInfo
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {
    @Insert
    fun insertProfileInfo(profileInfo: ProfileInfo)

    @Query("DELETE FROM profileInfo")
    fun deleteProfileInfo()

    @Query("SELECT * FROM profileInfo")
    fun getProfileInfo(): ProfileInfo?

    @Query("SELECT * FROM pictureInfo")
    fun getPictureInfo(): Flow<List<PictureInfo>>

    @Insert
    fun insertPictureInfo(pictureInfo: List<PictureInfo>)

    @Insert
    fun updateFavoritePictureInfo(pictureInfo: PictureInfo)

    @Query("DELETE FROM pictureInfo")
    fun deleteAllMenuItems()

}