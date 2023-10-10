package com.dev.ipati.multiapp.di

import com.dev.ipati.multiapp.CommonViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import org.koin.dsl.module
import platform.AVFoundation.AVPlayer
import platform.AVFoundation.setAllowsExternalPlayback
import platform.AVFoundation.setVolume

val module = module {
    viewModelFactory {
        CommonViewModel()
    }

    single {
        AVPlayer().apply {
            setVolume(1.0f)
            setAllowsExternalPlayback(true)
        }
    }
}

