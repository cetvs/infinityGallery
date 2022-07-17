package com.example.myapplication.data.source.remote

import com.example.myapplication.domain.model.PictureInfo
import retrofit2.http.GET
import retrofit2.http.Headers

interface SimpleApi {
    @Headers(
//        "Content-Type: application/json",
        "Authorization: Token 916a807ed82cf88839b24568e2776d123bd18f61a169bd25fd31e737ef0ba53e"
    )
    @GET("picture")
    suspend fun getPictureInfo(): List<PictureInfo>
}