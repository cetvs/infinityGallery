package com.example.domain.usecase

import com.example.domain.model.ProfileInfo
import com.example.domain.repository.MainRepository

class InsertProfileInfo(
    private val repository: MainRepository
) {
    operator fun invoke(profileInfo: ProfileInfo) {
        repository.insertProfileInfo(profileInfo)
    }
}