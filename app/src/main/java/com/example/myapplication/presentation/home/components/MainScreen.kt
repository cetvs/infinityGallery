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
        mainViewModel.getPictureInfo(token)
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
    val pictureInfoListState = mainViewModel.state.value
    when {
        pictureInfoListState.error.isNotBlank() -> {
            ErrorMainContentScreen(navController, token, mainViewModel)
        }
        pictureInfoListState.value.isNotEmpty() -> {
            SuccessMainScreen(navController, token, mainViewModel)
        }
        pictureInfoListState.isLoading -> {
            LoadingScreen()
        }
    }
}