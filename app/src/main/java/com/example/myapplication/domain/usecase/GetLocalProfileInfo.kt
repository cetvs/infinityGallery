package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.model.ProfileInfo
import com.example.myapplication.domain.repository.MainRepository

class GetLocalProfileInfo(
    private val repository: MainRepository
) {
    operator fun invoke(): ProfileInfo? =
        repository.getLocalProfileInfo()
}