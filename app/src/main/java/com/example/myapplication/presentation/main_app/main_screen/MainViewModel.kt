package com.example.myapplication.presentation.main_app.main_screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.Resource
import com.example.myapplication.domain.model.PictureInfo
import com.example.myapplication.domain.usecase.MainUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
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

    private val _localState = mutableStateOf(listOf<PictureInfo>())
    val localState: State<List<PictureInfo>> = _localState

    fun getPictureInfo() {
        mainUseCases.getPictureInfo().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PictureInfoListState(value = result.data ?: emptyList())
                    viewModelScope.launch(Dispatchers.IO) {
                        mainUseCases.deleteAllMenuItems()
                        result.data?.let {
                            for(el in it)
                                Log.v("testSearch", el.id.toString())
//                            mainUseCases.insertPicturesInfo(it)
                        }
                    }
                }
                is Resource.Error ->
                    _state.value = PictureInfoListState(error = "internet error")
//                is Resource.Loading ->
//                    _state.value = PictureInfoListState(isLoading = true)
//                else -> if (result.data != null) _state.value =
//                    PictureInfoListState(value = result.data)
            }
        }.launchIn(viewModelScope)
    }

    fun getLocalPictureInfo() {
        mainUseCases.getLocalPictureInfo().onEach { result ->
            _localState.value = result
        }
    }
}