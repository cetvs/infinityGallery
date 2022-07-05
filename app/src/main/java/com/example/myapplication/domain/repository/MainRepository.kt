package com.example.myapplication.domain.repository

import com.example.myapplication.domain.model.PictureInfo
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getPictureInfo(): Flow<List<PictureInfo>>
    fun addFavoritePictureInfo(pictureInfo: PictureInfo)
}