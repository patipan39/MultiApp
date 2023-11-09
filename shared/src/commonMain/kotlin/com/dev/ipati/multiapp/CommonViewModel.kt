package com.dev.ipati.multiapp

import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import com.dev.ipati.multiapp.data.HomeResponse
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.launch

class CommonViewModel(
    private val albumUseCase: GetHomeUseCase
) : ViewModel() {

    val search = mutableStateOf("")

    @Stable
    val stateHome = mutableStateOf(listOf(HomeResponse.Data()))

    val stateError = mutableStateOf(Exception())

    init {
        viewModelScope.launch {
            when (val result = albumUseCase.execute()) {
                is Result.Success -> {
                    stateHome.value = result.data.component ?: emptyList()
                }

                is Result.Error -> {
                    stateError.value = result.e
                }
            }
        }
    }

    fun search(keyword: String) {
        search.value = keyword
    }
}