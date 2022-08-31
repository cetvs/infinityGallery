package com.example.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "pictureInfo")
data class EntityPictureInfo(
    @PrimaryKey
    val id: String,
    val title: String,
    val content: String,
    val photoUrl: String,
    val publicationDate: Long,
    val FavoriteDate: String
) : Parcelable

fun PictureInfo.toEntityPictureInfo(): EntityPictureInfo =
    EntityPictureInfo(
        id = this.id,
        title = this.title,
        content = this.content,
        photoUrl = this.photoUrl,
        publicationDate = this.publicationDate,
        FavoriteDate = "21",
    )