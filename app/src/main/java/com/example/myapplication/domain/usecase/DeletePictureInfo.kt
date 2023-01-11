package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.model.PictureInfo
import com.example.myapplication.domain.repository.MainRepository


class DeletePictureInfo(
    private val repository: MainRepository
) {
    operator fun invoke(pictureInfo: PictureInfo) {
        repository.deletePictureInfo(pictureInfo)
    }
}