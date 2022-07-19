package com.example.myapplication.presentation.main_app.main_screen.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBarText(text: String) {
    TopAppBar(
        backgroundColor = Color.White,
        contentColor = Color.Black,
        title = {
            Text(
                text = text,
                fontSize = 24.sp
            )
        },
        elevation = 0.dp
    )
}