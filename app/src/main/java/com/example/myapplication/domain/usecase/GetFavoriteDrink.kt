package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.model.EntityPictureInfo
import com.example.myapplication.domain.model.FavoriteDrink
import com.example.myapplication.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow

class GetFavoriteDrink(
    private val repository: MainRepository
) {
    suspend operator fun invoke(): List<FavoriteDrink> {
        return repository.getFavoriteDrink()
    }
}