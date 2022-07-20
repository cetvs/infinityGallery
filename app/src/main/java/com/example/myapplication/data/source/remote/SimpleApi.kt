package com.example.myapplication.data.source.remote

import com.example.myapplication.domain.model.PictureInfo
import retrofit2.http.GET
import retrofit2.http.Headers

interface SimpleApi {
    @Headers(
//        "Content-Type: application/json",
        "Authorization: Token 305f5c9aaa6afe8af90b97733395e71ae3ac8ff3f3cb752cf993ef790e3ee3ad"
    )
    @GET("picture")
    suspend fun getPictureInfo(): List<PictureInfo>
}