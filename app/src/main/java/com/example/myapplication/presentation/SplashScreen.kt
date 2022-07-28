package com.example.myapplication.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

@ExperimentalComposeUiApi
@Composable
fun SplashScreen(
) {
    Image(
        painter = painterResource(R.drawable.ic_splash),
        contentDescription = null,
        modifier = Modifier.size(230.dp),
        colorFilter = ColorFilter.tint(Color.Black)
    )
}