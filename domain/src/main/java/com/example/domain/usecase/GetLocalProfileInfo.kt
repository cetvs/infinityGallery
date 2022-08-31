package com.example.domain.usecase

import com.example.domain.model.ProfileInfo
import com.example.domain.repository.MainRepository

class GetLocalProfileInfo(
    private val repository: MainRepository
) {
    operator fun invoke(): ProfileInfo? =
        repository.getLocalProfileInfo()
}