package com.example.myapplication.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserInfo(
    val id: String,
    val phone: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val avatar: String,
    val city: String,
    val about: String
) : Parcelable