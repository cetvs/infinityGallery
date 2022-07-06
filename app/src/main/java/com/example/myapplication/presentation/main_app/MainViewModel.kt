package com.example.myapplication.presentation.main_app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.model.PictureInfo
import com.example.myapplication.domain.usecase.MainUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainUseCases: MainUseCases
) : ViewModel() {

    fun getFavoritePictureInfo(): Flow<List<PictureInfo>> {
        return mainUseCases.getFavoritePictureInfo()
    }

    fun getPictureInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            mainUseCases.getPictureInfo()
        }
    }

//        fun getPictureInfo(): Flow<List<PictureInfo>> {
//            return mainUseCases.getPictureInfo()
//        }

    fun addFavoritePictureInfo(pictureInfo: PictureInfo) {
        viewModelScope.launch(Dispatchers.IO) {
            mainUseCases.addFavoritePictureInfo(pictureInfo)
        }
    }

}