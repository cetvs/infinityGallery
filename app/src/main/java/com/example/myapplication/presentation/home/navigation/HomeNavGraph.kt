package com.example.myapplication.presentation.home.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.domain.model.PictureInfo
import com.example.domain.model.ProfileInfo
import com.example.myapplication.presentation.home.components.FavoriteScreen
import com.example.myapplication.presentation.home.components.MainScreen
import com.example.myapplication.presentation.home.components.ProfileScreen
import com.example.myapplication.presentation.home.main_screen.MainInfoDetailsScreen
import com.example.myapplication.presentation.home.main_screen.SearchScreen
import com.example.myapplication.presentation.home.models.NavItem

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun HomeNavGraph(navController: NavHostController, profileInfo: ProfileInfo) {
    NavHost(
        navController = navController,
        startDestination = NavItem.Main.route
    ) {
        composable(route = NavItem.Main.route) {
            MainScreen(navController, profileInfo.token)
        }
        composable(route = NavItem.Favorite.route) {
            FavoriteScreen()
        }
        composable(route = NavItem.Profile.route) {
            ProfileScreen(profileInfo)
        }
        composable(
            route = NavItem.Details.route
        ) {
            navController.previousBackStackEntry?.arguments?.
            getParcelable<PictureInfo>("MENU_ITEM")?.let {
                MainInfoDetailsScreen(navController, it)
            }
        }
        composable(
            route = NavItem.Search.route
        ) {
            SearchScreen(navController, profileInfo.token)
        }
    }
}