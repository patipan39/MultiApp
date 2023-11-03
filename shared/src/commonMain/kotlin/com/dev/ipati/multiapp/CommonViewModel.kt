package com.dev.ipati.multiapp

import androidx.compose.runtime.mutableStateOf
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.launch

class CommonViewModel(
    private val albumUseCase: GetAlbumUseCase
) : ViewModel() {

    val stateAlbum = mutableStateOf<Result>(Result.Success)

    init {
        viewModelScope.launch {
            val result = albumUseCase.execute()
            stateAlbum.value = result
        }
    }
}