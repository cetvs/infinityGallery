package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.repository.MainRepository


class DeleteProfileInfo(
    private val repository: MainRepository
) {
    operator fun invoke() {
        repository.deleteProfileInfo()
    }
}