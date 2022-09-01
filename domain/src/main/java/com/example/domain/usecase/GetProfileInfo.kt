package com.example.domain.usecase

import com.example.domain.common.BAD_REQUEST
import com.example.domain.common.HAVE_NOT_INTERNET
import com.example.domain.model.ProfileInfo
import com.example.domain.model.ProfileRequestBody
import com.example.domain.model.Resource
import com.example.domain.repository.MainRepository
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