package com.example.myapplication.presentation.main_app

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.presentation.main_app.models.PictureInfo

@ExperimentalFoundationApi
@Composable
fun MainGrid() {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier.padding(16.dp, 16.dp, 0.dp, 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(
            count = gridList.size,
            itemContent = {
                MenuListItem(gridList[it])
            }
        )
    }
}

@Composable
fun MenuListItem(menuItem: PictureInfo) {
    Column() {
        val scale = 1.1
        Box(){
            Image(
                painter = painterResource(id = R.drawable.grid_item),
                contentDescription = null,
                modifier = Modifier
                    .size((160 * scale).dp, (222 * scale).dp)
            )
            Image(
                painter = painterResource(id = R.drawable.grid_item),
                contentDescription = null,
                modifier = Modifier
                    .size((160 * scale).dp, (222 * scale).dp)
            )
        }

        Text(text = menuItem.title)

    }
}

val gridElement = PictureInfo(
    "1",
    "Шлепа в тазике",
    "Распространите",
    "https://i.pinimg.com/originals/1e/ad/f4/1eadf4027937d699a83ac0905d82204a.jpg",
    1655456376904
)
val gridList = listOf(
    gridElement,
    gridElement.copy(id = "2"),
    gridElement.copy(id = "3"),
    gridElement.copy(id = "4"),
    gridElement.copy(id = "5")
)


