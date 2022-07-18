package com.example.myapplication.presentation.main_app.main_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.Resource
import com.example.myapplication.domain.model.PictureInfo
import com.example.myapplication.domain.usecase.MainUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainUseCases: MainUseCases
) : ViewModel() {

    private val _state = mutableStateOf(PictureInfoListState())
    val state: State<PictureInfoListState> = _state

//    private val _state = mutableStateOf(listOf<PictureInfo>())
//    val state: State<List<PictureInfo>> = _state

    fun getFavoritePictureInfo(): Flow<List<PictureInfo>> {
        return mainUseCases.getFavoritePictureInfo()
    }

//    fun getPictureInfo() {
//        mainUseCases.getPictureInfo().onEach { result ->
//            when (result) {
//                is Resource.Success ->
//                    _state.value = PictureInfoListState(value = result.data ?: listOf())
//                is Resource.Error ->
//                    _state.value = PictureInfoListState(error = "An unexpected error occured")
//                is Resource.Loading ->
//                    _state.value = PictureInfoListState(isLoading = true)
//            }
//        }.launchIn(viewModelScope)
//    }

    fun getPictureInfo() {
        mainUseCases.getPictureInfo().onEach { result ->
            when (result) {
                is Resource.Success ->
                    if (result.data != null) _state.value =
                        PictureInfoListState(value = result.data)
                is Resource.Loading ->
                    _state.value = PictureInfoListState(isLoading = true)
                else -> if (result.data != null) _state.value =
                    PictureInfoListState(value = result.data)
            }
        }.launchIn(viewModelScope)
    }

    fun addFavoritePictureInfo(pictureInfo: PictureInfo) {
        viewModelScope.launch(Dispatchers.IO) {
            mainUseCases.addFavoritePictureInfo(pictureInfo)
        }
    }

}