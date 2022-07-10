package com.example.myapplication.presentation.main_app.main_screen

import com.example.myapplication.domain.model.PictureInfo

data class PictureInfoListState(
    val value : List<PictureInfo> = emptyList(),
    val error : String = "",
    val isLoading: Boolean = false
)