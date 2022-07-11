package com.example.myapplication.data.source.remote

import com.example.myapplication.domain.model.PictureInfo
import retrofit2.http.GET
import retrofit2.http.Headers

interface SimpleApi {
    @Headers(
//        "Content-Type: application/json",
        "Authorization: Token 5de85a91ad1386dc18fce82888ca1fbae7662049361c24c454a6e162fc42dcd2"
    )
    @GET("picture")
    suspend fun getPictureInfo(): List<PictureInfo>
}