package com.dev.ipati.multiapp

import androidx.compose.runtime.mutableStateOf
import dev.icerock.moko.mvvm.viewmodel.ViewModel

class CommonViewModel : ViewModel() {
    val progress = mutableStateOf(80f / 100f)
}