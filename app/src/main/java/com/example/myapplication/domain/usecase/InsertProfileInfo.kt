package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.model.ProfileInfo
import com.example.myapplication.domain.repository.MainRepository

class InsertProfileInfo(
    private val repository: MainRepository
) {
    operator fun invoke(profileInfo: ProfileInfo) {
        repository.insertProfileInfo(profileInfo)
    }
}