package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.model.EntityPictureInfo
import com.example.myapplication.domain.repository.MainRepository

class InsertPicturesInfo(
    private val repository: MainRepository
) {
    operator fun invoke(picturesInfo: List<EntityPictureInfo>) {
        repository.insertPicturesInfo(picturesInfo)
    }
}