package com.example.myapplication.domain.usecase

import androidx.paging.Pager
import com.example.myapplication.common.Resource
import com.example.myapplication.data.source.local.DrinkInfoEntity
import com.example.myapplication.domain.model.DrinkInfoRemote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

//class GetDrinksInfoPaging(
//    private val pager: Pager<Int, DrinkInfoEntity>
//) {
//    operator fun invoke(page: Int): Flow<Resource<List<DrinkInfoRemote>>> {
//        return pager
//        flow {
//            try {
//                val picturesList = repository.getDrinksInfoRemote(page)
//                emit(Resource.Success(picturesList))
//            } catch (e: HttpException) {
//                Log.v(TAG, "HttpException")
//            }
//        }
//    }
//
//    companion object {
//        const val TAG = "GetDrinksInfoRemote"
//    }
//}