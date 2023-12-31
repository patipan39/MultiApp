package com.dev.ipati.multiapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.ipati.multiapp.Result
import com.dev.ipati.multiapp.data.ProfileData
import com.dev.ipati.multiapp.usecase.GetProfileUseCase
import dev.icerock.moko.mvvm.livedata.MutableLiveData
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val profileUseCase: GetProfileUseCase
) : ViewModel() {

    val currentLoginSocial = MutableLiveData(ProfileData(emptyList(), emptyList()))

    init {
        getCurrentLoginSocial()
    }

    private fun getCurrentLoginSocial() {
        viewModelScope.launch {
            when (val result = profileUseCase.execute()) {
                is Result.Success -> {
                    currentLoginSocial.value = result.data
                }

                is Result.Error -> {

                }
            }
        }
    }
}