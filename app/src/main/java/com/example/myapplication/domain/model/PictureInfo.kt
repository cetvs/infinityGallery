package com.example.myapplication.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PictureInfo(
    val id: String,
    val title: String,
    val content: String,
    var photoUrl: String,
    val publicationDate: Long,
) : Parcelable