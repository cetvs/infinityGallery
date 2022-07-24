package com.example.myapplication.presentation.home.main_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myapplication.presentation.MainViewModel
import com.example.myapplication.presentation.home.main_screen.components.SearchBar
import com.example.myapplication.presentation.home.main_screen.components.SearchGrid

@ExperimentalFoundationApi
@Composable
fun SearchScreen(
    navController: NavController,
    token: String,
    mainViewModel: MainViewModel = hiltViewModel(),
) {
    Column {
        SearchBar(navController)
        SearchGrid(navController, token, mainViewModel)
    }
}