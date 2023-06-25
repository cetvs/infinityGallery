package com.example.myapplication.data.source.remote

import com.example.myapplication.domain.model.DrinkInfoRemote
import com.example.myapplication.domain.model.PictureInfo
import com.example.myapplication.domain.model.ProfileInfo
import com.example.myapplication.domain.model.ProfileRequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface SimpleApi {
//    @Headers(
//        "Authorization: Token 305f5c9aaa6afe8af90b97733395e71ae3ac8ff3f3cb752cf993ef790e3ee3ad"
//    )

    @GET("picture")
    suspend fun getDrinksInfo(@Header("Authorization") token: String): List<DrinkInfoRemote>

    @GET("picture")
    suspend fun getPictureInfo(@Header("Authorization") token: String): List<PictureInfo>

    @POST("auth/login")
    suspend fun getProfileInfo(@Body requestBody: ProfileRequestBody): ProfileInfo?

    @POST("auth/logout")
    suspend fun postAuthLogout(@Header("Authorization") token: String): Response<Unit>
}