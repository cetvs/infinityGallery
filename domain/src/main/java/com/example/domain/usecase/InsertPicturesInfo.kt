package com.example.domain.usecase

import com.example.domain.model.EntityPictureInfo
import com.example.domain.repository.MainRepository

class InsertPicturesInfo(
    private val repository: MainRepository
) {
    operator fun invoke(picturesInfo: List<EntityPictureInfo>) {
        repository.insertPicturesInfo(picturesInfo)
    }
}