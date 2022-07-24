package com.example.myapplication.presentation.home.models

import com.example.myapplication.R

sealed class NavItem(
    val name: String,
    val route: String,
    val icon: Int?,
) {
    object Main : NavItem(
        route = "main",
        name = "Главная",
        icon = R.drawable.ic_main
    )

    object Favorite : NavItem(
        route = "favorite",
        name = "Избранное",
        icon = R.drawable.ic_unfavorite
    )

    object Profile : NavItem(
        route = "profile",
        name = "Профиль",
        icon = R.drawable.ic_profile
    )

    object Details : NavItem(
        route = "details",
        name = "Детали",
        icon = null
    )

    object Search : NavItem(
        route = "search",
        name = "Поиск",
        icon = null
    )
}
