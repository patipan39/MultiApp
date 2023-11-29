package com.dev.ipati.multiapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import com.dev.ipati.multiapp.Result
import com.dev.ipati.multiapp.data.HomeResponse
import com.dev.ipati.multiapp.usecase.GetHomeUseCase
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CommonViewModel(
    private val albumUseCase: GetHomeUseCase
) : ViewModel() {

    val search = mutableStateOf("")

    private val _stateHome = MutableStateFlow<List<HomeResponse.Data>>(emptyList())
    val stateHome = _stateHome.asStateFlow()
    private val stateError = mutableStateOf(Exception())

    fun search(keyword: String) {
        search.value = keyword
    }

    fun getHomeComponent() {
        viewModelScope.launch {
            when (val result = albumUseCase.execute()) {
                is Result.Success -> {
                    _stateHome.update {
                        result.data.component?.toList() ?: emptyList()
                    }
                }

                is Result.Error -> {
                    stateError.value = result.e
                }
            }
        }
    }
}