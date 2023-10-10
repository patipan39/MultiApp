package com.dev.ipati.multiapp.di

import io.ktor.utils.io.errors.IOException
import org.koin.core.context.startKoin

object KoinHelper {
    fun doInitKoin() {
        startKoin {
            modules(
                PlatformModule.initialModule()
            )
        }
    }
}

