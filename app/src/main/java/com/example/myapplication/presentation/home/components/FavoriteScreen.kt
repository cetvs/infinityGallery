package com.example.myapplication.presentation.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.myapplication.common.convertLongToTime
import com.example.myapplication.domain.model.EntityPictureInfo
import com.example.myapplication.presentation.MainViewModel

@Composable
fun FavoriteScreen(mainViewModel: MainViewModel = hiltViewModel()) {
    val favorite = mutableListOf<EntityPictureInfo>()//TODO FAVORITES
        // mainViewModel.getLocalPictureInfo()
    Column() {
        TopBarText(text = "Мои избранные")
        LazyColumn() {
            items(
                count = favorite.size,
                itemContent = {
                    MainGridListItem(favorite[it])
                }
            )
        }
    }
}

@Composable
fun MainGridListItem(entityPictureInfo: EntityPictureInfo) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .padding(16.dp, 0.dp, 16.dp, 0.dp)
    ) {
        AsyncImage(
            model = entityPictureInfo.photoUrl,
            contentDescription = null,
            modifier = Modifier
                .size(326.dp, 326.dp)
                .align(Alignment.CenterHorizontally)
        )
        Box(Modifier.fillMaxWidth()) {
            Text(
                text = entityPictureInfo.title,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Text(
                text = entityPictureInfo.FavoriteDate.toLong().convertLongToTime(),
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier.align(Alignment.TopEnd)
            )
        }
        Text(
            text = entityPictureInfo.content,
            maxLines = 1,
            fontSize = 12.sp,
            overflow = TextOverflow.Ellipsis
        )
    }
}