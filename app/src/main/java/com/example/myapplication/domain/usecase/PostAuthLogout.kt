package com.example.myapplication.domain.usecase

import com.example.myapplication.common.HAVE_NOT_INTERNET
import com.example.myapplication.common.Resource
import com.example.myapplication.domain.repository.MainRepository
import retrofit2.HttpException
import java.io.IOException

class PostAuthLogout(
    private val repository: MainRepository
) {
    suspend operator fun invoke(token: String): Resource<Boolean> =
        try {
            repository.postAuthLogout(token)
            Resource.Success(true)
        } catch (e: HttpException) {
            Resource.Success(true)
        } catch (e: IOException) {
            Resource.Error(HAVE_NOT_INTERNET)
        }
}
