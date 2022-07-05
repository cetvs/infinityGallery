package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.model.PictureInfo
import com.example.myapplication.domain.repository.MainRepository

class AddFavoritePictureInfo(
    private val repository: MainRepository
) {
    operator fun invoke(pictureInfo: PictureInfo) {
        repository.addFavoritePictureInfo(pictureInfo)
    }
}