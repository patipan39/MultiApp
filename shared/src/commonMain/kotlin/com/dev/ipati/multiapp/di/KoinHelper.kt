package com.dev.ipati.multiapp.di

import org.koin.core.context.startKoin

object KoinHelper {
    fun doInitKoin() {
        startKoin {
            modules(
                PlatformModule.initialModule() + commonModule
            )
        }
    }
}

