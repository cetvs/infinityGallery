package com.example.myapplication.presentation.main_app.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.myapplication.presentation.main_app.main_screen.components.SuccessMainScreen

@ExperimentalFoundationApi
@Composable
fun MainScreen(navController: NavHostController) {
    SuccessMainScreen(navController)
}

const val GALLERY = "Галерея"