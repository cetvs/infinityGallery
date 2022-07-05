package com.example.myapplication.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pictureInfo")
data class PictureInfo(
    @PrimaryKey
    val id: String,
    val title: String,
    val content: String,
    val photoUrl: String,
    val publicationDate: Long,
)