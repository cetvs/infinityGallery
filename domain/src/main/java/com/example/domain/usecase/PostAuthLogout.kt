package com.example.domain.usecase

import com.example.domain.common.HAVE_NOT_INTERNET
import com.example.domain.model.Resource
import com.example.domain.repository.MainRepository
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
