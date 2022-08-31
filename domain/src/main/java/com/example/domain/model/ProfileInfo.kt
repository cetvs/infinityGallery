package com.example.domain.model

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "profileInfo")
data class ProfileInfo(
    @PrimaryKey
    val token: String,
    @SerializedName("user_info")
    @Embedded
    val userInfo: UserInfo,
) : Parcelable