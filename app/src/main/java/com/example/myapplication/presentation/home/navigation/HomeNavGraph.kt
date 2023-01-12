package com.example.myapplication.presentation.home.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myapplication.common.URLParser
import com.example.myapplication.domain.model.PictureInfo
import com.example.myapplication.domain.model.ProfileInfo
import com.example.myapplication.presentation.home.components.FavoriteScreen
import com.example.myapplication.presentation.home.components.MainScreen
import com.example.myapplication.presentation.home.components.ProfileScreen
import com.example.myapplication.presentation.home.main_screen.MainInfoDetailsScreen
import com.example.myapplication.presentation.home.main_screen.SearchScreen
import com.example.myapplication.presentation.home.models.NavItem
import com.google.gson.Gson
import java.net.URLDecoder
import java.net.URLEncoder

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
            route = "${NavItem.Details.route}/{jsonPictureInfo}",
            arguments = listOf(
                navArgument("jsonPictureInfo") {
                    type = NavType.StringType
                }
            )
        ) {
            val jsonPictureInfo = it.arguments?.getString("jsonPictureInfo")
            var pictureInfo = Gson().fromJson(jsonPictureInfo, PictureInfo::class.java)
            pictureInfo.photoUrl =  URLParser('^').decode(pictureInfo.photoUrl)
            MainInfoDetailsScreen(navController, pictureInfo)
        }
        composable(
            route = NavItem.Search.route
        ) {
            SearchScreen(navController, profileInfo.token)
        }
    }
}