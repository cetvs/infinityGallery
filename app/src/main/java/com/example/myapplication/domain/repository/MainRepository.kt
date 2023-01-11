package com.example.myapplication.domain.repository

import com.example.myapplication.domain.model.EntityPictureInfo
import com.example.myapplication.domain.model.PictureInfo
import com.example.myapplication.domain.model.ProfileInfo
import com.example.myapplication.domain.model.ProfileRequestBody

interface MainRepository {
    suspend fun getProfileInfo(profileRequestBody: ProfileRequestBody): ProfileInfo?
    suspend fun getPictureInfo(token: String): List<PictureInfo>
    fun getLocalPictureInfo(): List<EntityPictureInfo>
    fun insertPicturesInfo(picturesInfo: List<EntityPictureInfo>)
    fun deleteAllMenuItems()
    fun insertProfileInfo(profileInfo: ProfileInfo)
    fun deleteProfileInfo()
    fun getLocalProfileInfo(): ProfileInfo?
    suspend fun postAuthLogout(token: String)
    fun deletePictureInfo(id: String)
}