package com.example.myapplication.presentation.main_app.main_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import com.example.myapplication.domain.model.ProfileInfo
import com.example.myapplication.presentation.main_app.ButtonBar

@ExperimentalFoundationApi
@Composable
fun AppMainScreen(profileInfo: ProfileInfo) {
    ButtonBar(profileInfo)
}
