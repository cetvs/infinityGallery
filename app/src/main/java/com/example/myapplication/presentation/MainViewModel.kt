package com.example.myapplication.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.myapplication.data.source.local.DrinkInfoEntity
import com.example.myapplication.domain.model.*
import com.example.myapplication.domain.usecase.MainUseCases
import com.example.myapplication.presentation.home.main_screen.DrinksInfoListState
import com.example.myapplication.presentation.home.main_screen.PictureInfoListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    pager: Pager<Int, DrinkInfoEntity>,
    private val mainUseCases: MainUseCases
) : ViewModel() {

    val drinkPagingFlow = pager
        .flow
        .map { pagingData ->
            pagingData.map { it.toDrinksInfoUi() }
        }
        .cachedIn(viewModelScope)

    private val _localStateFavorite = mutableStateOf(listOf<EntityPictureInfo>())
    val localStateFavorite: State<List<EntityPictureInfo>> = _localStateFavorite

    private val _stateDrinks = mutableStateOf(DrinksInfoListState())
    val stateDrinks: State<DrinksInfoListState> = _stateDrinks

    fun getDrinksInfoRemote() {
        mainUseCases.getDrinksInfoRemote(1).onEach { result ->
            Log.v(TAG, result.data?.toString() ?: "")
            _stateDrinks.value = DrinksInfoListState(value = result.data ?: emptyList())
        }.launchIn(viewModelScope)
    }

    fun getFavoriteDrink() : List<FavoriteDrink> {
       return runBlocking(Dispatchers.IO) {
            mainUseCases.getFavoriteDrink()
        }
    }

    fun insertPictureInfo(picturesInfo: List<EntityPictureInfo>) {
        viewModelScope.launch(Dispatchers.IO) {
            mainUseCases.insertPicturesInfo(picturesInfo)
        }
    }

    fun deletePictureInfo(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            mainUseCases.deletePictureInfo(id)
        }
    }

    fun insertFavoriteDrink(favoriteDrink: FavoriteDrink) {
        viewModelScope.launch(Dispatchers.IO) {
            mainUseCases.insertFavoriteDrink(favoriteDrink)
        }
    }

    fun deleteFavoriteDrink(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            mainUseCases.deleteFavoriteDrink(id)
        }
    }

    companion object {
        const val TAG = "MainViewModel"
    }
}