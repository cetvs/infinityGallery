package com.example.myapplication.presentation.home.main_screen.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.domain.model.PictureInfo
import com.example.myapplication.R
import com.example.myapplication.presentation.MainViewModel
import com.example.myapplication.presentation.home.models.NavItem
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@ExperimentalFoundationApi
@Composable
fun MainScreenContent(
    navController: NavHostController,
    mainViewModel: MainViewModel,
) {
//    MainGrid(navController, token, mainViewModel)
}


@ExperimentalFoundationApi
@Composable
fun MainGrid(navController: NavController, token: String, mainViewModel: MainViewModel) {
    val picturesState = mainViewModel.state.value
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
                    MainGridListItem(picturesState.value[it], it, navController)
                }
            )
        }
    }
}

@Composable
fun MainGridListItem(menuItem: PictureInfo, index: Int, navController: NavController) {
    Column(Modifier.clickable {
        val arguments = navController.currentBackStackEntry?.arguments
        arguments?.putParcelable("MENU_ITEM", menuItem)
        navController.navigate(NavItem.Details.route)
    }) {
        MainGridListImage(menuItem = menuItem, index = index)
        Text(text = menuItem.title)
    }
}

@Composable
fun MainGridListImage(menuItem: PictureInfo, index: Int) {
    val scale = 1.1
    Box() {
        AsyncImage(
            model = menuItem.photoUrl,
            contentDescription = null,
            modifier = Modifier
                .size((160 * scale).dp, (222 * scale).dp)
        )
        IconButton(
            onClick = {
//                favorite[index] = !favorite[index]
            },
            modifier = Modifier.padding(130.dp, 0.dp, 0.dp, 0.dp),

            ) {
            Icon(
                painter = painterResource(
//                    id = if (favorite[index])
                    R.drawable.ic_favorite
//                    else R.drawable.ic_unfavorite
                ),
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}
