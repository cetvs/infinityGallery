package com.example.myapplication.presentation.main_app.main_screen.components

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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.myapplication.R
import com.example.myapplication.domain.model.PictureInfo
import com.example.myapplication.presentation.main_app.main_screen.MainViewModel
import com.example.myapplication.presentation.main_app.main_screen.PictureInfoListState
import com.example.myapplication.presentation.main_app.models.NavItem

@ExperimentalFoundationApi
@Composable
fun MainScreenContent(
    navController: NavHostController,
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val pictureInfoListState = mainViewModel.state.value
    mainViewModel.getPictureInfo()
    if (pictureInfoListState.error.isEmpty()) {
        MainGrid(navController, pictureInfoListState)
    } else {
        ErrorMainContent()
    }
}


@ExperimentalFoundationApi
@Composable
fun MainGrid(navController: NavHostController, pictureInfoListState: PictureInfoListState) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier.padding(16.dp, 16.dp, 0.dp, 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(
            count = pictureInfoListState.value.size,
            itemContent = {
                MenuListItem(pictureInfoListState.value[it], it, navController)
            }
        )
    }
}

@Composable
fun MenuListItem(menuItem: PictureInfo, index: Int, navController: NavHostController) {
    Column(Modifier.clickable {
        val arguments = navController.currentBackStackEntry?.arguments
        arguments?.putParcelable("MENU_ITEM", menuItem)
        navController.navigate(NavItem.Details.route)
    }) {
        MenuListImage(menuItem = menuItem, index = index)
        Text(text = menuItem.title)
    }
}

@Composable
fun MenuListImage(menuItem: PictureInfo, index: Int) {
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
