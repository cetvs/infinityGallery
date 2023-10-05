package com.example.myapplication.data.source.remote

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.myapplication.data.source.local.AppDatabase
import com.example.myapplication.data.source.local.DrinkInfoEntity
import com.example.myapplication.data.source.mappers.toDrinkInfoEntity
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class DrinkRemoteMediator(
    private val drinksDb: AppDatabase,
    private val drinksApi: DrinksApi,
) : RemoteMediator<Int, DrinkInfoEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, DrinkInfoEntity>,
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        1
                    } else {
                        (lastItem.id / state.config.pageSize) + 1
                    }
                }
            }

            val pageMap = mutableMapOf<String, Int>().also {
                it["page"] = loadKey
            }
            val drinks = drinksApi.getDrinksInfo(pageMap)
            Log.v(TAG, "drinks $drinks")

            drinksDb.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    drinksDb.menuDao().deleteAllMenuItems()
                }
                val favoriteDrinks = drinksDb.menuDao().getFavoriteDrinks()
                Log.v(TAG, "favoriteDrinks: $favoriteDrinks")
                val drinkEntities = drinks.map { it.toDrinkInfoEntity() }.toMutableList()

                drinkEntities.forEachIndexed { index, drink ->
                    favoriteDrinks.forEach { favoriteDrink ->
                        if (drink.id == favoriteDrink.id){
                            drinkEntities[index] = drink.copy(isFavorite = true)
                        }
                    }
                }
                Log.v(TAG, "favoriteDrinks: $drinkEntities")
                drinksDb.menuDao().insertDrinksInfo(drinkEntities)
            }

            MediatorResult.Success(
                endOfPaginationReached = drinks.isEmpty()
            )
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }

    companion object {
        const val TAG = "DrinkRemoteMediator"
    }
}