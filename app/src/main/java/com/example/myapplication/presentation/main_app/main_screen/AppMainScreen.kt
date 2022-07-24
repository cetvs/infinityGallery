package com.example.myapplication.presentation.main_app.main_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.domain.model.PictureInfo
import com.example.myapplication.domain.model.ProfileInfo
import com.example.myapplication.presentation.main_app.ButtonBar
import com.example.myapplication.presentation.main_app.models.NavItem

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun AppMainScreen(profileInfo: ProfileInfo) {
    val navController: NavHostController = rememberNavController()
    RootMain(navController, profileInfo)
//    ButtonBar(profileInfo)
}

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun RootMain(
    navController: NavHostController, // NavHostController,
    profileInfo: ProfileInfo
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(route = "home"){
            ButtonBar(profileInfo = profileInfo)
        }
//        homeGraph(navController, profileInfo)
        composable(route = NavItem.Details.route) {
            navController.previousBackStackEntry?.arguments?.
            getParcelable<PictureInfo>("MENU_ITEM")?.let {
                MainInfoDetailsScreen(navController, it)
            }
        }
        composable(route = NavItem.Search.route) {
            SearchScreen(navController, profileInfo.token)
        }

    }
}

//@ExperimentalComposeUiApi
//@ExperimentalFoundationApi
//fun NavGraphBuilder.homeGraph(navController: NavController, profileInfo: ProfileInfo) {
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
//}
