package com.example.myapplication.data.source.remote

import com.example.myapplication.domain.model.PictureInfo
import retrofit2.http.GET
import retrofit2.http.Headers

interface SimpleApi {
    @Headers(
//        "Content-Type: application/json",
        "Authorization: Token 937dc80f85179696c918f2c17e51d8702d46f12f8ebac7cae994802a52434df9"
    )
    @GET("picture")
    suspend fun getPictureInfo(): List<PictureInfo>
}