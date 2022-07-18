package com.example.myapplication.data.source.remote

import com.example.myapplication.domain.model.PictureInfo
import retrofit2.http.GET
import retrofit2.http.Headers

interface SimpleApi {
    @Headers(
//        "Content-Type: application/json",
        "Authorization: Token ef5bb80dae709cd2a0ea7dac4104e8646465283ebf6dcfdc030198eb1b966c6e"
    )
    @GET("picture")
    suspend fun getPictureInfo(): List<PictureInfo>
}