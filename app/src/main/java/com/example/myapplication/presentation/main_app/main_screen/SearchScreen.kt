package com.example.myapplication.presentation.main_app.main_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.myapplication.presentation.MainViewModel
import com.example.myapplication.presentation.main_app.main_screen.components.SearchBar
import com.example.myapplication.presentation.main_app.main_screen.components.SearchGrid

@ExperimentalFoundationApi
@Composable
fun SearchScreen(
    navController: NavHostController,
    mainViewModel: MainViewModel = hiltViewModel(),
) {
    Column {
        SearchBar(navController)
        SearchGrid(navController, mainViewModel)
    }
}