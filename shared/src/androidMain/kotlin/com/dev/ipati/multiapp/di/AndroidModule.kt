package com.dev.ipati.multiapp.di

import androidx.media3.common.AudioAttributes
import androidx.media3.exoplayer.ExoPlayer
import com.dev.ipati.multiapp.CommonViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val module = module {
    viewModelOf(::CommonViewModel)

    single {
        val builder = ExoPlayer.Builder(androidContext()).apply {
            setHandleAudioBecomingNoisy(true)
            setAudioAttributes(AudioAttributes.DEFAULT, true)
        }
        val exoPlayer = builder.build()
        exoPlayer.volume = 1.0f
        exoPlayer
    }
}
