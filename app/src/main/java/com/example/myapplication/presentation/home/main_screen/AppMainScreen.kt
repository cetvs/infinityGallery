package com.example.myapplication.presentation.home.main_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.example.domain.model.ProfileInfo
import com.example.myapplication.presentation.home.ButtonBar

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun HomeScreen(profileInfo: ProfileInfo) {
    ButtonBar(profileInfo)
}
