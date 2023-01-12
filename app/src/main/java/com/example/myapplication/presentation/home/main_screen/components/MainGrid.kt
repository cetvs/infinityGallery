package com.example.myapplication.presentation.home.main_screen.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.myapplication.R
import com.example.myapplication.common.URLParser
import com.example.myapplication.domain.model.EntityPictureInfo
import com.example.myapplication.domain.model.PictureInfo
import com.example.myapplication.domain.model.toEntityPictureInfo
import com.example.myapplication.presentation.MainViewModel
import com.example.myapplication.presentation.home.models.NavItem
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

lateinit var favorites: MutableList<EntityPictureInfo>

@ExperimentalFoundationApi
@Composable
fun MainGrid(navController: NavController, token: String, mainViewModel: MainViewModel) {
    val picturesState = mainViewModel.state.value
    favorites = mainViewModel.getLocalPictureInfo().toMutableList()
    SwipeRefresh(
        state = rememberSwipeRefreshState(false),
        onRefresh = { mainViewModel.getPictureInfo(token) },
    ) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            modifier = Modifier.padding(16.dp, 16.dp, 0.dp, 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(
                count = picturesState.value.size,
                itemContent = {
                    MainGridListItem(picturesState.value[it], navController, mainViewModel)
                }
            )
        }
    }
}

@Composable
fun MainGridListItem(
    menuItem: PictureInfo,
    navController: NavController,
    mainViewModel: MainViewModel
) {
    Column(
        Modifier.clickable {
            val encodeUrl = URLParser('^').encode(menuItem.photoUrl)
            val pictureInfo = menuItem.copy(photoUrl = encodeUrl)
            val gsonPictureInfo = Gson().toJson(pictureInfo)
            navController.navigate("${NavItem.Details.route}/$gsonPictureInfo")
        }
    ) {
        MainGridListImage(menuItem = menuItem, mainViewModel = mainViewModel)
        Text(text = menuItem.title)
    }
}

@Composable
fun MainGridListImage(menuItem: PictureInfo, mainViewModel: MainViewModel) {
    val foundedIndex = favorites.indexOfFirst { it.id == menuItem.id }
    val icon = if (foundedIndex == -1) R.drawable.ic_unfavorite else R.drawable.ic_favorite
    var favoriteIcon by remember { mutableStateOf(icon) }
    favoriteIcon = icon
    val scale = 1.1
    Box() {
        AsyncImage(
            model = menuItem.photoUrl,
            contentDescription = null,
            modifier = Modifier.size((160 * scale).dp, (222 * scale).dp)
        )
        IconButton(
            onClick = {
                val index = favorites.indexOfFirst { it.id == menuItem.id }
                if ((index == -1)) {
                    favoriteIcon = R.drawable.ic_favorite
                    favorites.add(menuItem.toEntityPictureInfo())
                    mainViewModel.insertPictureInfo(picturesInfo = listOf(menuItem.toEntityPictureInfo()))
                } else {
                    favoriteIcon = R.drawable.ic_unfavorite
                    favorites.removeAt(index)
                    mainViewModel.deletePictureInfo(menuItem.id)
                }
            },
            modifier = Modifier.padding(130.dp, 0.dp, 0.dp, 0.dp),
        ) {
            Icon(
                painter = painterResource(id = favoriteIcon),
                contentDescription = null,
                tint = Color.Gray
            )
        }
    }
}