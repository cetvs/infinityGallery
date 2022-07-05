package com.example.myapplication.presentation.main_app

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.presentation.main_app.components.FavoriteScreen
import com.example.myapplication.presentation.main_app.components.MainScreen
import com.example.myapplication.presentation.main_app.components.ProfileScreen
import com.example.myapplication.presentation.main_app.models.BottomNavItem

@ExperimentalFoundationApi
@Composable
fun ButtonBar() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                listOf(
                    BottomNavItem.Main,
                    BottomNavItem.Favorite,
                    BottomNavItem.Profile
                ),
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                }
            )
        }
    ) {
        BottomNavGraph(navController)
    }
}

@ExperimentalFoundationApi
@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Main.route
    ) {
        composable(route = BottomNavItem.Main.route) {
            MainScreen()
        }
        composable(route = BottomNavItem.Favorite.route) {
            FavoriteScreen()
        }
        composable(route = BottomNavItem.Profile.route) {
            ProfileScreen()
        }
    }
}

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavHostController,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        elevation = 5.dp,
        backgroundColor = Color.White,

    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.name) },
                label = { Text(text = item.name) },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Gray,
            )
        }
    }
}