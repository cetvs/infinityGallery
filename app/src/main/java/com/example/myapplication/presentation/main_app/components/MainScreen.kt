package com.example.myapplication.presentation.main_app.components

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.myapplication.presentation.MainViewModel
import com.example.myapplication.presentation.main_app.main_screen.ErrorMainContentScreen
import com.example.myapplication.presentation.main_app.main_screen.SuccessMainScreen
import com.example.myapplication.presentation.main_app.main_screen.components.LoadingScreen

@ExperimentalFoundationApi
@Composable
fun MainScreen(
    navController: NavHostController,
    token: String,
    mainViewModel: MainViewModel = hiltViewModel()
) {
    mainViewModel.getPictureInfo(token)
    Log.v("MainScreen", "1")
    MainCall(navController, token, mainViewModel)
}

@ExperimentalFoundationApi
@Composable
fun MainCall(
    navController: NavHostController,
    token: String,
    mainViewModel: MainViewModel
) {
    val pictureInfoListState = mainViewModel.state.value
    Log.v("MainCall", "2")
//    SearchScreen(navController = navController)
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