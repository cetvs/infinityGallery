package com.example.myapplication.presentation.home.main_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.myapplication.R
import com.example.myapplication.domain.model.DrinksInfoUi
import com.example.myapplication.domain.model.FavoriteDrink
import com.example.myapplication.presentation.MainViewModel

private lateinit var favorites: MutableList<FavoriteDrink>

@Composable
fun MainInfoDetailsScreen(
    navController: NavHostController,
    drinksInfoUi: DrinksInfoUi,
    viewModel: MainViewModel = hiltViewModel(),
) {
    favorites = viewModel.getFavoriteDrink().toMutableList()
    Column() {
        TopBar(navController, viewModel, drinksInfoUi)
        PictureInfoDetails(drinksInfoUi)
    }
}

@Composable
fun TopBar(navController: NavHostController, viewModel: MainViewModel, drinksInfoUi: DrinksInfoUi) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                modifier = Modifier,
                contentDescription = null
            )
        }
        val foundedIndex = favorites.indexOfFirst { it.id == drinksInfoUi.id }
        val icon = if (foundedIndex != -1) {
            R.drawable.ic_favorite
        } else {
            R.drawable.ic_unfavorite
        }
        var favoriteIcon by remember { mutableStateOf(icon) }
        favoriteIcon = icon
        Box(
        ) {
            IconButton(
                onClick = {
                    val foundedIndex = favorites.indexOfFirst { it.id == drinksInfoUi.id }
                    if (foundedIndex == -1) {
                        favoriteIcon = R.drawable.ic_favorite
                        favorites.add(FavoriteDrink(id = drinksInfoUi.id, isFavorite = true))
                        viewModel.insertFavoriteDrink(favoriteDrink = FavoriteDrink(drinksInfoUi.id, true))
                    } else {
                        favoriteIcon = R.drawable.ic_unfavorite
                        favorites.removeAt(foundedIndex)
                        viewModel.deleteFavoriteDrink(drinksInfoUi.id.toString())
                    }
                },
                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 0.dp),
            ) {
                Icon(
                    painter = painterResource(id = favoriteIcon),
                    contentDescription = null,
                    tint = Color.Gray
                )
            }
        }
    }
}

@Composable
fun PictureInfoDetails(drinksInfoUi: DrinksInfoUi) {
    Column(
        modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp)
    ) {
        Row() {
            AsyncImage(
                model = drinksInfoUi.imageUrl,
                contentDescription = null,
                modifier = Modifier.size(470.dp)
            )
        }
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