package com.example.myapplication.domain.usecase

class MainUseCases(
    val getDrinksInfoRemote: GetDrinksInfoRemote,
    val getFavoriteDrink: GetFavoriteDrink,
    val insertFavoriteDrink: InsertFavoriteDrink,
    val deleteFavoriteDrink: DeleteFavoriteDrink,
)