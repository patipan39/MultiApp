package com.dev.ipati.multiapp.di

import androidx.media3.common.AudioAttributes
import androidx.media3.exoplayer.ExoPlayer
import com.dev.ipati.multiapp.media.IMediaPlayer
import com.dev.ipati.multiapp.media.MediaPlayerImpl
import com.dev.ipati.multiapp.service.IKtorService
import com.dev.ipati.multiapp.service.KtorServiceImpl
import com.dev.ipati.multiapp.viewmodel.CommonViewModel
import com.dev.ipati.multiapp.viewmodel.ProfileViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val module = module {
    viewModelOf(::CommonViewModel)
    viewModelOf(::ProfileViewModel)

    factoryOf(::KtorServiceImpl) bind IKtorService::class

    single {
        val builder = ExoPlayer.Builder(androidContext()).apply {
            setHandleAudioBecomingNoisy(true)
            setAudioAttributes(AudioAttributes.DEFAULT, true)
        }
        val exoPlayer = builder.build()
        exoPlayer.volume = 1.0f
        exoPlayer
    }

    singleOf(::MediaPlayerImpl) bind IMediaPlayer::class
}
