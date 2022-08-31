package com.example.domain.usecase

import com.example.domain.model.EntityPictureInfo
import com.example.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow

class GetLocalPictureInfo(
    private val repository: MainRepository
) {
    operator fun invoke(): Flow<List<EntityPictureInfo>> {
        return repository.getLocalPictureInfo()
    }
}