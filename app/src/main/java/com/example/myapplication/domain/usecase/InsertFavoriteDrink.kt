package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.model.FavoriteDrink
import com.example.myapplication.domain.repository.MainRepository

class InsertFavoriteDrink(
    private val repository: MainRepository
) {
    operator fun invoke(favoriteDrink: FavoriteDrink) {
        repository.insertFavoriteDrink(favoriteDrink)
    }
}