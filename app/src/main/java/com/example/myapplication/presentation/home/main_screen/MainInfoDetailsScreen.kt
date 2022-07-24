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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.myapplication.R
import com.example.myapplication.common.convertLongToTime
import com.example.myapplication.domain.model.PictureInfo

@Composable
fun MainInfoDetailsScreen(
    navController: NavHostController,
    pictureInfo: PictureInfo
) {
    Column() {
        TopBar(navController)
        PictureInfoDetails(pictureInfo)
    }
}

@Composable
fun TopBar(navController: NavHostController) {
    Row() {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null
            )
        }
        Text(
            text = stringResource(R.string.Gallery),
            modifier = Modifier.padding(14.dp, 17.dp, 0.dp, 0.dp),
        )
    }
}

@Composable
fun PictureInfoDetails(pictureInfo: PictureInfo) {
    Column() {
        AsyncImage(
            model = pictureInfo.photoUrl,
            contentDescription = null,
            modifier = Modifier.size(380.dp)
        )
        Row() {
            Text(pictureInfo.title)
            Text(
                text = pictureInfo.publicationDate.convertLongToTime(),
                modifier = Modifier.padding(120.dp, 0.dp, 0.dp, 0.dp)
            )
        }
        Text(
            text = pictureInfo.content,
            modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp)
        )
    }
}