package com.example.myapplication.presentation.main_app.main_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.myapplication.R
import com.example.myapplication.presentation.MainViewModel
import com.example.myapplication.presentation.main_app.main_screen.components.MainGrid
import com.example.myapplication.presentation.main_app.models.NavItem

@ExperimentalFoundationApi
@Composable
fun SuccessMainScreen(navController: NavController, token: String, mainViewModel: MainViewModel) {
    Column {
        Box(Modifier.height(50.dp)) {
            TopAppBar(
                backgroundColor = Color.White,
                contentColor = Color.Black,
                title = {
                    Text(
                        text = stringResource(R.string.Gallery),
                        fontSize = 24.sp
                    )
                },
                actions = {
                    IconButton(onClick = { navController.navigate(NavItem.Search.route) }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = "Localized description"
                        )
                    }
                },
                elevation = 0.dp
            )
        }
//        MainScreenContent(navController, mainViewModel)
        MainGrid(navController, token, mainViewModel)
    }
}