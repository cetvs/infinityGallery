package com.example.myapplication.presentation.main_app.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.domain.model.PictureInfo
import com.example.myapplication.domain.model.ProfileInfo
import com.example.myapplication.presentation.main_app.components.FavoriteScreen
import com.example.myapplication.presentation.main_app.components.MainScreen
import com.example.myapplication.presentation.main_app.components.ProfileScreen
import com.example.myapplication.presentation.main_app.main_screen.MainInfoDetailsScreen
import com.example.myapplication.presentation.main_app.main_screen.SearchScreen
import com.example.myapplication.presentation.main_app.models.NavItem

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