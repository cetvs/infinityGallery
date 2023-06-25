package com.example.myapplication.data.source.remote

import com.example.myapplication.domain.model.DrinkInfoRemote
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface DrinksApi {
    @GET("beers")
    suspend fun getDrinksInfo(@QueryMap options: Map<String, Int>): List<DrinkInfoRemote>
}