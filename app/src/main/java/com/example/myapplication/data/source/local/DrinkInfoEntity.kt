package com.example.myapplication.data.source.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "drinkInfo")
data class DrinkInfoEntity (
    @PrimaryKey
    val id: Int,
    val name: String,
    val description: String,
    val isFavorite: Boolean,
    val imageUrl: String
)