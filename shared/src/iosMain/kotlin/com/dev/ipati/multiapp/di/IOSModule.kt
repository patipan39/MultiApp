package com.dev.ipati.multiapp.di

import com.dev.ipati.multiapp.CommonViewModel
import com.dev.ipati.multiapp.media.MediaWrapper
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val module = module {
    factoryOf(::CommonViewModel)

    single {
        MediaWrapper()
    }
}

