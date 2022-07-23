package com.example.myapplication.domain.usecase

import com.example.myapplication.common.Resource
import com.example.myapplication.domain.model.ProfileInfo
import com.example.myapplication.domain.model.ProfileRequestBody
import com.example.myapplication.domain.repository.MainRepository
import retrofit2.HttpException

class GetProfileInfo(
    private val repository: MainRepository
) {
    suspend operator fun invoke(profileRequestBody: ProfileRequestBody): Resource<ProfileInfo> =
            try {
                val profileInfo = repository.getProfileInfo(profileRequestBody)
                Resource.Success(data = profileInfo)
            } catch (e: HttpException) {
                Resource.Error(e.localizedMessage ?: "An unexpected error occured")
            }

}