package com.example.myapplication.presentation.home.main_screen.components

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.example.myapplication.R
import com.example.myapplication.common.URLParser
import com.example.myapplication.domain.model.DrinksInfoUi
import com.example.myapplication.domain.model.FavoriteDrink
import com.example.myapplication.presentation.MainViewModel
import com.example.myapplication.presentation.home.models.NavItem
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.google.gson.Gson

private lateinit var favorites: MutableList<FavoriteDrink>

@ExperimentalFoundationApi
@Composable
fun MainScreenPaging(navController: NavController, viewModel: MainViewModel) {
    favorites = viewModel.getFavoriteDrink().toMutableList()

    val drinks = viewModel.drinkPagingFlow.collectAsLazyPagingItems()

    SwipeRefresh(
        state = rememberSwipeRefreshState(false),
        onRefresh = { drinks.refresh() },
    ) {
        MainGridPaging(drinks, navController, viewModel)
    }
}


@Composable
fun MainGridPaging(drinks: LazyPagingItems<DrinksInfoUi>, navController: NavController, viewModel: MainViewModel) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (drinks.loadState.refresh is LoadState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(
                    count = drinks.itemCount
                ) { index ->
                    val item = drinks.get(index)
                    if (item != null) {
                        MainGridListItem(item, navController, viewModel)
                    }
                }

                if (drinks.loadState.append == LoadState.Loading) {
                    item {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentWidth(Alignment.CenterHorizontally)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun MainGridListItem(
    menuItem: DrinksInfoUi,
    navController: NavController,
    mainViewModel: MainViewModel,
) {
    Column(
        modifier = Modifier.clickable {
            val encodeUrl = URLParser('^').encode(menuItem.imageUrl)
            val drinkInfoRemote = menuItem.copy(imageUrl = encodeUrl)
            val gsonPictureInfo = Gson().toJson(drinkInfoRemote)
            navController.navigate("${NavItem.Details.route}/$gsonPictureInfo")
        },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MainGridListImage(menuItem = menuItem, mainViewModel = mainViewModel)
        Text(text = menuItem.name)
    }
}

@Composable
private fun MainGridListImage(menuItem: DrinksInfoUi, mainViewModel: MainViewModel) {
    val foundedIndex = favorites.indexOfFirst { it.id == menuItem.id }
    val icon = if (foundedIndex != -1) {
        R.drawable.ic_favorite
    } else {
        R.drawable.ic_unfavorite
    }
    var favoriteIcon by remember { mutableStateOf(icon) }
    favoriteIcon = icon
    val scale = 1.1
    Box(
    ) {
        AsyncImage(
            model = menuItem.imageUrl,
            contentDescription = null,
            modifier = Modifier.size((250 * scale).dp, (300 * scale).dp)
        )
        IconButton(
            onClick = {
                val foundedIndex = favorites.indexOfFirst { it.id == menuItem.id }
                if (foundedIndex == -1) {
                    favoriteIcon = R.drawable.ic_favorite
                    favorites.add(FavoriteDrink(id = menuItem.id, isFavorite = true))
                    mainViewModel.insertFavoriteDrink(favoriteDrink = FavoriteDrink(menuItem.id, true))
                } else {
                    favoriteIcon = R.drawable.ic_unfavorite
                    favorites.removeAt(foundedIndex)
                    mainViewModel.deleteFavoriteDrink(menuItem.id.toString())
                }
            },
            modifier = Modifier.padding(200.dp, 0.dp, 0.dp, 0.dp),
        ) {
            Icon(
                painter = painterResource(id = favoriteIcon),
                contentDescription = null,
                tint = Color.Gray
            )
        }
    }
}

const val TAG = "DrinkRemoteMediator"