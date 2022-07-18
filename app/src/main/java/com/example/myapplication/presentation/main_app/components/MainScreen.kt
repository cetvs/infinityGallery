package com.example.myapplication.presentation.main_app.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myapplication.R
import com.example.myapplication.presentation.main_app.main_screen.components.MainScreenContent
import com.example.myapplication.presentation.main_app.main_screen.components.SearchCompose

@ExperimentalFoundationApi
@Composable
fun MainScreen(navController: NavHostController) {
    val isSearchState = remember { mutableStateOf(false) }
    Column {
        Box(Modifier.height(50.dp)) {
            if (!isSearchState.value) {
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
                        IconButton(onClick = { isSearchState.value = true }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_search),
                                contentDescription = "Localized description"
                            )
                        }
                    },
                    elevation = 0.dp
                )
            } else {
                SearchCompose(isSearchState)
            }
        }
        MainScreenContent(navController)
    }
}

const val GALLERY = "Галерея"