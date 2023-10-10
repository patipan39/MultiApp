package com.dev.ipati.multiapp.di

import com.dev.ipati.multiapp.CommonViewModel
import com.dev.ipati.multiapp.media.MediaWrapper
import dev.icerock.moko.mvvm.compose.viewModelFactory
import org.koin.dsl.module

val module = module {
    viewModelFactory {
        CommonViewModel()
    }

    single {
        MediaWrapper()
    }
}

