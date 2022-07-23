package com.example.myapplication.domain.repository

import com.example.myapplication.domain.model.PictureInfo
import com.example.myapplication.domain.model.ProfileInfo
import com.example.myapplication.domain.model.ProfileRequestBody
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    suspend fun getProfileInfo(profileRequestBody: ProfileRequestBody): ProfileInfo
    suspend fun getPictureInfo(token: String): List<PictureInfo>
    fun getLocalPictureInfo(): Flow<List<PictureInfo>>
    fun insertPicturesInfo(picturesInfo: List<PictureInfo>)
    fun deleteAllMenuItems()
    fun insertProfileInfo(profileInfo: ProfileInfo)
    fun deleteProfileInfo()
    fun getLocalProfileInfo(): ProfileInfo?
}