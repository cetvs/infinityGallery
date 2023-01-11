package com.example.myapplication.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.domain.model.EntityPictureInfo
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
    fun getPictureInfo(): List<EntityPictureInfo>

    @Insert
    fun insertPicturesInfo(entityPictureInfo: List<EntityPictureInfo>)

    @Insert
    fun updateFavoritePictureInfo(entityPictureInfo: EntityPictureInfo)

    @Query("DELETE FROM pictureInfo WHERE id = :pictureId")
    fun deletePicturesInfo(pictureId: String)

    @Query("DELETE FROM pictureInfo")
    fun deleteAllMenuItems()

}