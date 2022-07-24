package com.example.myapplication.presentation.main_app.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.presentation.main_app.models.NavItem

@ExperimentalAnimationApi
@Composable
fun ListContainer(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavItem.Main.route
    ) {
        composable(route = NavItem.Main.route) {

        }

//        composable(route = NavItem.Main.route) {
//            MainScreen(navController, profileInfo.token)
//        }
//        composable(route = NavItem.Favorite.route) {
//            FavoriteScreen()
//        }
//        composable(route = NavItem.Profile.route) {
//            ProfileScreen(profileInfo)
//        }
    }
}