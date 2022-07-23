package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.repository.MainRepository

class PostAuthLogout(
    private val repository: MainRepository
) {
    suspend operator fun invoke(token: String) {
        repository.postAuthLogout(token)
    }
}