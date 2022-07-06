package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.repository.MainRepository

class GetPictureInfo(
    private val repository: MainRepository
) {
    suspend operator fun invoke() {
        repository.getPictureInfo()
    }
//    operator fun invoke(): Flow<List<PictureInfo>> {
//        return repository.getPictureInfo()
//    }
}