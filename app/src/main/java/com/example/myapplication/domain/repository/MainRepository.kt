package com.example.myapplication.domain.repository

import com.example.myapplication.domain.model.PictureInfo
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    suspend fun getPictureInfo(): List<PictureInfo>
    fun addFavoritePictureInfo(pictureInfo: PictureInfo)
    fun getFavoritePictureInfo(): Flow<List<PictureInfo>>
}