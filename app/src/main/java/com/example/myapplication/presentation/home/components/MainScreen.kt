package com.example.myapplication.presentation.home.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myapplication.presentation.MainViewModel
import com.example.myapplication.presentation.home.main_screen.ErrorMainContentScreen
import com.example.myapplication.presentation.home.main_screen.SuccessMainScreen
import com.example.myapplication.presentation.home.main_screen.components.LoadingScreen

@ExperimentalFoundationApi
@Composable
fun MainScreen(
    navController: NavController,
    token: String,
    mainViewModel: MainViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = token) {
        mainViewModel.getDrinksInfoRemote()
    }
    MainCall(navController, token, mainViewModel)
}

@ExperimentalFoundationApi
@Composable
fun MainCall(
    navController: NavController,
    token: String,
    mainViewModel: MainViewModel
) {
    SuccessMainScreen(navController, token, mainViewModel)
}