package com.example.myapplication.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "pictureInfo")
data class PictureInfo(
    @PrimaryKey
//    @SerializedName("id")
    val id: String,
//    @SerializedName("title")
    val title: String,
//    @SerializedName("content")
    val content: String,
//    @SerializedName("photoUrl")
    val photoUrl: String,
//    @SerializedName("publicationDate")
    val publicationDate: Long,
) : Parcelable