package com.example.myapplication.presentation.home.main_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.presentation.MainViewModel
import com.example.myapplication.presentation.home.main_screen.components.MainScreenPaging

@ExperimentalFoundationApi
@Composable
fun SuccessMainScreen(navController: NavController, token: String, mainViewModel: MainViewModel) {
    Column {
        Box(Modifier.height(50.dp)) {
            TopAppBar(
                modifier = Modifier.padding(0.dp, 4.dp, 0.dp, 0.dp),
                backgroundColor = Color.White,
                contentColor = Color.Black,
                title = {
                    Text(
                        text = "Галерея",
                        fontSize = 24.sp
                    )
                },
                elevation = 0.dp
            )
        }
//        MainGrid(navController, mainViewModel)
        MainScreenPaging(navController, mainViewModel)
    }
}