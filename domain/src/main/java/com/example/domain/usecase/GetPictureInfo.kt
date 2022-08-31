package com.example.domain.usecase

import com.example.domain.common.BAD_REQUEST
import com.example.domain.common.HAVE_NOT_INTERNET
import com.example.domain.model.PictureInfo
import com.example.domain.model.Resource
import com.example.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetPictureInfo(
    private val repository: MainRepository
) {
    operator fun invoke(token: String): Flow<Resource<List<PictureInfo>>> =
        flow {
            try {
                emit(Resource.Loading())
                val picturesList = repository.getPictureInfo(token)
                emit(Resource.Success(picturesList))
            } catch (e: HttpException) {
                emit(Resource.Error(BAD_REQUEST))
            } catch (e: IOException) {
                emit(Resource.Error(HAVE_NOT_INTERNET))
            }
        }
}