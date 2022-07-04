package com.example.myapplication.presentation.main_app

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.myapplication.presentation.main_app.components.FavoriteScreen
import com.example.myapplication.presentation.main_app.components.MainScreen
import com.example.myapplication.presentation.main_app.components.ProfileScreen
import com.example.myapplication.presentation.main_app.models.BottomNavItem

@Preview()
@Composable
fun AppMainScreen() {

}

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
        elevation = 5.dp
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
