package com.dev.ipati.multiapp.di

import com.dev.ipati.multiapp.media.IMediaPlayer
import com.dev.ipati.multiapp.media.MediaPlayerImpl
import com.dev.ipati.multiapp.media.MediaWrapper
import com.dev.ipati.multiapp.service.IKtorService
import com.dev.ipati.multiapp.service.KtorServiceImpl
import com.dev.ipati.multiapp.viewmodel.CommonViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val module = module {
    factoryOf(::CommonViewModel)
    factoryOf(::KtorServiceImpl) bind IKtorService::class
    single {
        MediaWrapper()
    }
    singleOf(::MediaPlayerImpl) bind IMediaPlayer::class
}

