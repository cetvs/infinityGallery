package com.example.myapplication.presentation.main_app.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myapplication.R
import com.example.myapplication.presentation.main_app.main_screen.components.MainGrid
import com.example.myapplication.presentation.main_app.main_screen.components.SearchCompose

@ExperimentalFoundationApi
@Composable
fun MainScreen(navController: NavHostController) {
    var isSearch by remember { mutableStateOf(false) }
    Column {
//        SearchCompose()
        if (!isSearch) {
            TopAppBar(
                backgroundColor = Color.White,
                contentColor = Color.Black,
                title = {
                    Text(
                        text = GALLERY,
                        fontSize = 24.sp
                    )
                },
                actions = {
                    IconButton(onClick = { isSearch = true }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = "Localized description"
                        )
                    }
                },
                elevation = 0.dp
            )
        } else {
            SearchCompose()
        }
        MainGrid(navController)
    }
}

const val GALLERY = "Галерея"