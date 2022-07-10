package com.example.myapplication.presentation.main_app.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.presentation.main_app.main_screen.components.MainGrid

@ExperimentalFoundationApi
@Composable
fun MainScreen(
) {
    Column() {
        TopAppBar(
            backgroundColor = Color.White,
            contentColor = Color.Black,
            title = {
                Text(
                    text = GALLERY,
                    modifier = Modifier.padding(14.dp, 17.dp, 0.dp, 0.dp),
                )
            },
            actions = {
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.Search, contentDescription = "Localized description")
                }
            }
        )
        MainGrid()
    }
}

const val GALLERY = "Галерея"