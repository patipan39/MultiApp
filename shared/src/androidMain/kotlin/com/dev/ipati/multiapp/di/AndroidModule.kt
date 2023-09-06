package com.dev.ipati.multiapp.di

import androidx.media3.common.AudioAttributes
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val androidModule = module {
    single { (param: MediaItem) ->
        val builder = ExoPlayer.Builder(androidContext()).apply {
            setHandleAudioBecomingNoisy(true)
            setAudioAttributes(AudioAttributes.DEFAULT, true)
        }
        val exoPlayer = builder.build()
        exoPlayer.volume = 1.0f
        exoPlayer.setMediaItem(param)
        exoPlayer.prepare()
        exoPlayer
    }
}