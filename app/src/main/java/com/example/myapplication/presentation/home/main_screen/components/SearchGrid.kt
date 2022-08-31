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
import coil.compose.AsyncImage
import com.example.domain.model.EntityPictureInfo
import com.example.myapplication.R
import com.example.myapplication.presentation.MainViewModel
import com.example.myapplication.presentation.home.models.NavItem
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@ExperimentalFoundationApi
@Composable
fun SearchGrid(navController: NavController, token: String, mainViewModel: MainViewModel) {
//    val pictureInfo = PictureInfo(
//        "54",
//        "Шлепа в тазике",
//        "43",
//        "https://i.pinimg.com/originals/1e/ad/f4/1eadf4027937d699a83ac0905d82204a.jpg",
//        1655456376904
//    )
//    mainViewModel.insertPicturesInfo(listOf(pictureInfo))

    val picturesLocalState = mainViewModel.localState.value
//    Log.v("pictures", picturesLocalState.size.toString())
    mainViewModel.getLocalPictureInfo()
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
                count = picturesLocalState.size,
                itemContent = {
                    SearchGridListItem(picturesLocalState[it], navController)
                }
            )
        }
    }
}

@Composable
fun SearchGridListItem(menuItem: EntityPictureInfo, navController: NavController) {
    Column(Modifier.clickable {
        navController.navigate(NavItem.Details.route)
    }) {
        SearchGridListImage(menuItem = menuItem)
        Text(text = menuItem.title)
    }
}

@Composable
fun SearchGridListImage(menuItem: EntityPictureInfo) {
    val scale = 1.1
    Box {
        AsyncImage(
            model = menuItem.photoUrl,
            contentDescription = null,
            modifier = Modifier
                .size((160 * scale).dp, (222 * scale).dp)
        )
        IconButton(
            onClick = {
            },
            modifier = Modifier.padding(130.dp, 0.dp, 0.dp, 0.dp),

            ) {
            Icon(
                painter = painterResource(
                    R.drawable.ic_favorite
                ),
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}
