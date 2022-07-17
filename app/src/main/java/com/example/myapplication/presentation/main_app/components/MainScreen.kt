package com.example.myapplication.presentation.main_app.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.myapplication.presentation.main_app.main_screen.components.MainGrid
import com.example.myapplication.presentation.main_app.main_screen.components.SearchCompose

@ExperimentalFoundationApi
@Composable
fun MainScreen(navController: NavHostController) {
    Column {
        SearchCompose()
//        TopAppBar(
//            backgroundColor = Color.White,
//            contentColor = Color.Black,
//            title = {
//                Text(
//                    text = GALLERY,
////                    modifier = Modifier.padding(14.dp, 17.dp, 0.dp, 0.dp),
//                    fontSize = 24.sp
//                )
//            },
//            actions = {
//                IconButton(onClick = { /* doSomething() */ }) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.ic_search),
//                        contentDescription = "Localized description"
//                    )
//                }
//            }
//        )
        MainGrid(navController)
    }
}

const val GALLERY = "Галерея"