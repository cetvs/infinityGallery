package com.example.myapplication.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.domain.model.ProfileInfo
import com.example.myapplication.presentation.home.models.NavItem
import com.example.myapplication.presentation.home.navigation.HomeNavGraph

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun ButtonBar() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                listOf(
                    NavItem.Main,
                    NavItem.Favorite,
                    NavItem.Profile
                ),
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                }
            )
        }
    ) {
        HomeNavGraph(navController)
    }
}

@Composable
fun BottomNavigationBar(
    items: List<NavItem>,
    navController: NavHostController,
    onItemClick: (NavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry.value?.destination

    val screens = listOf(
        NavItem.Main,
        NavItem.Favorite,
        NavItem.Profile,
    )
    val bottomBarDestination = screens.any { it.route == currentDestination?.route }

    if (bottomBarDestination) {
        BottomNavigation(
            elevation = 5.dp,
            backgroundColor = Color.White
        ) {
            items.forEach { item ->
                val selected = item.route == backStackEntry.value?.destination?.route
                BottomNavigationItem(
                    selected = selected,
                    onClick = { onItemClick(item) },
                    icon = {
                        Icon(
                            painterResource(id = item.icon!!),
                            contentDescription = item.name
                        )
                    },
                    label = { Text(text = item.name) },
                    selectedContentColor = Color.Black,
                    unselectedContentColor = Color.Gray,
                )
            }
        }
    }
}