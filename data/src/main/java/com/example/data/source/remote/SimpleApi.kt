package com.example.data.source.remote

import com.example.domain.model.PictureInfo
import com.example.domain.model.ProfileInfo
import com.example.domain.model.ProfileRequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface SimpleApi {
    @GET("picture")
    suspend fun getPictureInfo(@Header("Authorization") token: String): List<PictureInfo>

    @POST("auth/login")
    suspend fun getProfileInfo(@Body requestBody: ProfileRequestBody): ProfileInfo?

    @POST("auth/logout")
    suspend fun postAuthLogout(@Header("Authorization") token: String): Response<Unit>
}