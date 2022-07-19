package com.example.myapplication.data.source.remote

import com.example.myapplication.domain.model.PictureInfo
import retrofit2.http.GET
import retrofit2.http.Headers

interface SimpleApi {
    @Headers(
//        "Content-Type: application/json",
        "Authorization: Token b35d27a498f9b1cde23f5f37d2c78fd0057ab5f6cc97d9f322f55995561be910"
    )
    @GET("picture")
    suspend fun getPictureInfo(): List<PictureInfo>
}