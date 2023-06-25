package com.example.myapplication.presentation.home.main_screen

import com.example.myapplication.domain.model.DrinkInfoRemote

data class DrinksInfoListState(
    val value : List<DrinkInfoRemote> = emptyList(),
    val error : String = "",
    val isLoading: Boolean = false
)