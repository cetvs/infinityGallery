package com.example.myapplication.data.source.remote

import com.example.myapplication.domain.model.PictureInfo
import retrofit2.http.GET
import retrofit2.http.Headers

interface SimpleApi {
    @Headers(
//        "Content-Type: application/json",
        "Authorization: Token 2f97c44eab25d9b124c479d965096b579e6ff03f65a67a26c97c33e8d162d32a"
    )
    @GET("picture")
    suspend fun getPictureInfo(): List<PictureInfo>
}