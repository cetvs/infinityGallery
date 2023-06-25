package com.example.myapplication.presentation.home.main_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.myapplication.R
import com.example.myapplication.common.convertLongToTime
import com.example.myapplication.domain.model.DrinksInfoUi

@Composable
fun MainInfoDetailsScreen(
    navController: NavHostController,
    drinksInfoUi: DrinksInfoUi
) {
    Column() {
        TopBar(navController)
        PictureInfoDetails(drinksInfoUi)
    }
}

@Composable
fun TopBar(navController: NavHostController) {
    Row() {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                modifier = Modifier,
                contentDescription = null
            )
        }
        Text(
            text = stringResource(R.string.Gallery),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp, 4.dp, 0.dp, 0.dp),
        )
    }
}

@Composable
fun PictureInfoDetails(drinksInfoUi: DrinksInfoUi) {
    Column(
        modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp)
    ) {
        AsyncImage(
            model = drinksInfoUi.imageUrl,
            contentDescription = null,
            modifier = Modifier.size(380.dp)
        )
        Row() {
            Text(
                text = drinksInfoUi.name,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
        Text(
            text = drinksInfoUi.description,
            modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp),
            fontSize = 12.sp
        )
    }
}