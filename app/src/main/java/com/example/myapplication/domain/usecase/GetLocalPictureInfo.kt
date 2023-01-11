package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.model.EntityPictureInfo
import com.example.myapplication.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow

class GetLocalPictureInfo(
    private val repository: MainRepository
) {
    operator fun invoke(): List<EntityPictureInfo> {
        return repository.getLocalPictureInfo()
    }
}