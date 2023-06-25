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
import com.example.myapplication.domain.model.UserInfo
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
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavItem.Main.route
    ) {
        composable(route = NavItem.Main.route) {
            MainScreen(navController, "token")
        }
        composable(route = NavItem.Favorite.route) {
            FavoriteScreen()
        }
        composable(route = NavItem.Profile.route) {
            ProfileScreen(mockProfileInfo())
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
            SearchScreen(navController, "token")
        }
    }
}

private fun mockProfileInfo(): ProfileInfo {
    return ProfileInfo(
        token = "23",
        userInfo = UserInfo(
            id = "2",
            phone = "+79518521812",
            email = "my@gmail.com",
            firstName = "Sergey",
            lastName = "Ivanov",
            avatar = "https://thumbs.dreamstime.com/b/creative-illustration-default-avatar-profile-placeholder-isolated-background-art-design-grey-photo-blank-template-mockup-144847501.jpg",
            city = "Moscow",
            about = "Информация обо мне"
        )
    )
}