package com.example.myapplication.domain.usecase

import android.util.Log
import com.example.myapplication.common.Resource
import com.example.myapplication.domain.model.DrinkInfoRemote
import com.example.myapplication.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class GetDrinksInfoRemote(
    private val repository: MainRepository,
) {
    operator fun invoke(page: Int): Flow<Resource<List<DrinkInfoRemote>>> =
        flow {
            try {
                val picturesList = repository.getDrinksInfoRemote(page)
                emit(Resource.Success(picturesList))
            } catch (e: HttpException) {
                Log.v(TAG, "HttpException")
            }
        }

    companion object {
        const val TAG = "GetDrinksInfoRemote"
    }
}