package com.example.myapplication.domain.usecase

import com.example.myapplication.common.BAD_REQUEST
import com.example.myapplication.common.HAVE_NOT_INTERNET
import com.example.myapplication.common.Resource
import com.example.myapplication.domain.model.ProfileInfo
import com.example.myapplication.domain.model.ProfileRequestBody
import com.example.myapplication.domain.repository.MainRepository
import retrofit2.HttpException
import java.io.IOException

class GetProfileInfo(
    private val repository: MainRepository
) {
    suspend operator fun invoke(profileRequestBody: ProfileRequestBody): Resource<ProfileInfo> =
        try {
            val profileInfo = repository.getProfileInfo(profileRequestBody)
            if (profileInfo != null) {
                Resource.Success(data = profileInfo)
            } else {
                Resource.Error(BAD_REQUEST)
            }
        } catch (e: HttpException) {
            Resource.Error(BAD_REQUEST)
        } catch (e: IOException) {
            Resource.Error(HAVE_NOT_INTERNET)
        }
}