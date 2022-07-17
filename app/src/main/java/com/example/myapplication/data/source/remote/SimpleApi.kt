package com.example.myapplication.data.source.remote

import com.example.myapplication.domain.model.PictureInfo
import retrofit2.http.GET
import retrofit2.http.Headers

interface SimpleApi {
    @Headers(
//        "Content-Type: application/json",
        "Authorization: Token 3027684da8763ac5c53526499cbba995a02775bce781b79adb78e245af9d1324"
    )
    @GET("picture")
    suspend fun getPictureInfo(): List<PictureInfo>
}