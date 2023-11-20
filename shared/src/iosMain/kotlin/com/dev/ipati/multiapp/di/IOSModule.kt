package com.dev.ipati.multiapp.di

import com.dev.ipati.multiapp.media.MediaWrapper
import com.dev.ipati.multiapp.viewmodel.CommonViewModel
import com.dev.ipati.multiapp.viewmodel.ProfileViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val module = module {
    factoryOf(::CommonViewModel)
    factoryOf(::ProfileViewModel)

    single {
        MediaWrapper()
    }
}

