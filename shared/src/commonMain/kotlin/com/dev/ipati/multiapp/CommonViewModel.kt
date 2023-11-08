package com.dev.ipati.multiapp

import androidx.compose.runtime.mutableStateOf
import com.dev.ipati.multiapp.data.AlbumResponse
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.launch

class CommonViewModel(
    private val albumUseCase: GetAlbumUseCase
) : ViewModel() {

    val stateAlbum = mutableStateOf(listOf(AlbumResponse.Song()))
    val stateError = mutableStateOf(Exception())

    init {
        viewModelScope.launch {
            when (val result = albumUseCase.execute()) {
                is Result.Success -> {
                    stateAlbum.value = result.data.data?.songList ?: emptyList()
                }

                is Result.Error -> {
                    stateError.value = result.e
                }
            }
        }
    }
}