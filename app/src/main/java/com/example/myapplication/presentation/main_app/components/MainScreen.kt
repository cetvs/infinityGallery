package com.example.myapplication.presentation.main_app.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.myapplication.presentation.main_app.main_screen.MainViewModel
import com.example.myapplication.presentation.main_app.main_screen.SuccessMainScreen
import com.example.myapplication.presentation.main_app.main_screen.components.ErrorMainContentScreen

@ExperimentalFoundationApi
@Composable
fun MainScreen(
    navController: NavHostController,
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val pictureInfoListState = mainViewModel.state.value
    mainViewModel.getPictureInfo()

//    SearchScreen(navController = navController)

    when {
        pictureInfoListState.error.isNotBlank() ->
            ErrorMainContentScreen()
//        pictureInfoListState.value.isNotEmpty() ->
//            SuccessMainScreen(navController = navController, pictures = pictureInfoListState.value)
//        pictureInfoListState.isLoading ->
//            LoadingScreen()
        else ->
            SuccessMainScreen(navController, mainViewModel)
    }
}