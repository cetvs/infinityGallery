package com.example.myapplication.presentation.main_app.main_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.example.myapplication.domain.model.ProfileInfo
import com.example.myapplication.presentation.main_app.ButtonBar

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun HomeScreen(profileInfo: ProfileInfo) {
    ButtonBar(profileInfo)
}
