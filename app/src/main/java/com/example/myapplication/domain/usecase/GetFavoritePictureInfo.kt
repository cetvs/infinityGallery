package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.model.PictureInfo
import com.example.myapplication.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow

class GetFavoritePictureInfo(
    private val repository: MainRepository
) {
    operator fun invoke(): Flow<List<PictureInfo>> {
        return repository.getFavoritePictureInfo()
    }
}