package com.example.myapplication.presentation.main_app.models

import com.example.myapplication.R

sealed class BottomNavItem(
    val name: String,
    val route: String,
    val icon: Int,
) {
    object Main : BottomNavItem(
        route = "main",
        name = "Главная",
        icon = R.drawable.ic_main
    )

    object Favorite : BottomNavItem(
        route = "favorite",
        name = "Избранное",
        icon =  R.drawable.ic_favorite
    )

    object Profile : BottomNavItem(
        route = "profile",
        name = "Профиль",
        icon = R.drawable.ic_profile
    )
}