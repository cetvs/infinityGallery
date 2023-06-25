package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.model.FavoriteDrink
import com.example.myapplication.domain.repository.MainRepository

class DeleteFavoriteDrink(
    private val repository: MainRepository
) {
    operator fun invoke(id: String) {
        repository.deleteFavoriteDrink(id)
    }
}