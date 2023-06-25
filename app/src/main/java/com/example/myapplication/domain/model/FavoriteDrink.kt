package com.example.myapplication.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "favoriteDrinks")
data class FavoriteDrink(
    @PrimaryKey
    val id: Int,
    val isFavorite: Boolean,
) : Parcelable