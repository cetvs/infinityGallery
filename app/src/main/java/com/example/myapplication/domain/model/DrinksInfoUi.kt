package com.example.myapplication.domain.model

import android.os.Parcelable
import com.example.myapplication.data.source.local.DrinkInfoEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DrinksInfoUi(
    val id: Int,
    val name: String,
    val description: String,
    val isFavorite: Boolean,
    val imageUrl: String,
) : Parcelable

fun DrinkInfoEntity.toDrinksInfoUi(): DrinksInfoUi {
    return DrinksInfoUi(
        id = this.id,
        name = this.name,
        description = this.description,
        isFavorite = false,
        imageUrl = this.imageUrl,
    )
}