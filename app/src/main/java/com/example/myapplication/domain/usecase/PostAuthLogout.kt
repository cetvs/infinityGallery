package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.repository.MainRepository
import retrofit2.HttpException
import java.io.IOException

class PostAuthLogout(
    private val repository: MainRepository
) {
    suspend operator fun invoke(token: String) : Boolean =
        try {
            repository.postAuthLogout(token)
            true
        } catch (e: HttpException) {
            true
        } catch (e: IOException) {
            false
        }
}