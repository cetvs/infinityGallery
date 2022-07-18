package com.example.myapplication.presentation.main_app.main_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.R

@Preview
@Composable
fun LoadingScreen() {
    Column() {
        Icon(
            painter = painterResource(
                R.drawable.ic_loader
            ),
            contentDescription = null,
            tint = Color.Black
        )
    }
}