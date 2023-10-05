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
import com.example.myapplication.domain.model.DrinkInfoRemote
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

private lateinit var favorites: MutableList<EntityPictureInfo>

@ExperimentalFoundationApi
@Composable
fun MainGrid(navController: NavController, mainViewModel: MainViewModel) {
    val drinksState = mainViewModel.stateDrinks.value
    favorites = mutableListOf<EntityPictureInfo>() //mainViewModel.getLocalPictureInfo().toMutableList()

    val drinkPagingFlow by mainViewModel.drinkPagingFlow.collectAsState(initial = null)
    
    SwipeRefresh(
        state = rememberSwipeRefreshState(false),
        onRefresh = {},
    ) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            modifier = Modifier.padding(16.dp, 16.dp, 0.dp, 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(
                count = drinksState.value.size,
                itemContent = {
                    MainGridListItem(drinksState.value[it], navController, mainViewModel)
                }
            )
        }
    }
}

@Composable
private fun MainGridListItem(
    menuItem: DrinkInfoRemote,
    navController: NavController,
    mainViewModel: MainViewModel,
) {
    Column(
        Modifier.clickable {
            val encodeUrl = URLParser('^').encode(menuItem.imageUrl)
            val drinkInfoRemote = menuItem.copy(imageUrl = encodeUrl)
            val gsonPictureInfo = Gson().toJson(drinkInfoRemote)
            navController.navigate("${NavItem.Details.route}/$gsonPictureInfo")
        }
    ) {
        MainGridListImage(menuItem = menuItem, mainViewModel = mainViewModel)
        Text(text = menuItem.name)
    }
}

@Composable
private fun MainGridListImage(menuItem: DrinkInfoRemote, mainViewModel: MainViewModel) {
//  TODO
    val foundedIndex = favorites.indexOfFirst { it.id == menuItem.id.toString() } //foundedIndex
    val icon =
        if (foundedIndex == -1) {
            R.drawable.ic_unfavorite
        } else {
            R.drawable.ic_favorite
        }
    var favoriteIcon by remember { mutableStateOf(icon) }
    favoriteIcon = icon
    val scale = 1.1
    Box() {
        AsyncImage(
            model = menuItem.imageUrl,
            contentDescription = null,
            modifier = Modifier.size((160 * scale).dp, (222 * scale).dp)
        )
        IconButton(
            onClick = {
                val index = favorites.indexOfFirst { it.id == menuItem.id.toString()  }
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