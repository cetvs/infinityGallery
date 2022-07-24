package com.example.myapplication.presentation.main_app.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.example.myapplication.domain.model.ProfileInfo

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
fun NavGraphBuilder.homeGraph(navController: NavController, profileInfo: ProfileInfo) {
//    navigation(startDestination = NavItem.Main.route, route = "home") {
//        composable(route = NavItem.Main.route) {
//            MainScreen(navController, profileInfo.token)
//        }
//        composable(route = NavItem.Favorite.route) {
//            FavoriteScreen()
//        }
//        composable(route = NavItem.Profile.route) {
//            ProfileScreen(profileInfo)
//        }
//    }
}
