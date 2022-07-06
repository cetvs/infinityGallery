package com.example.myapplication.data.source.remote

import com.example.myapplication.domain.model.PictureInfo
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Headers

interface SimpleApi {
    @Headers(
//        "Content-Type: application/json",
        "Authorization: Token 5575ca851643ad0f25b3ee809eb5637e367062a3bce2db174dd2a7f12c83f614"
    )
    @GET("picture")
    suspend fun getPictureInfo(): Flow<PictureInfo>
}