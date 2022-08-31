package com.example.domain.usecase

import com.example.domain.repository.MainRepository


class DeleteAllMenuItems(
    private val repository: MainRepository
) {
    operator fun invoke() {
        repository.deleteAllMenuItems()
    }
}