package com.example.myapplication.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DrinkInfoRemote(
    val id: Int,
    val name: String,
    val description: String,
    @SerializedName("image_url")
    val imageUrl: String
) : Parcelable