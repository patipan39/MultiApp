package com.dev.ipati.multiapp.di

import com.dev.ipati.multiapp.usecase.GetHomeUseCase
import com.dev.ipati.multiapp.usecase.GetProfileUseCase
import org.koin.core.context.startKoin
import org.koin.mp.KoinPlatform

object KoinHelper {
    fun doInitKoin() {
        startKoin {
            modules(
                PlatformModule.initialModule() + commonModule
            )
        }
    }

    fun getProfileUseCase(): GetProfileUseCase {
        return KoinPlatform.getKoin().get<GetProfileUseCase>()
    }

    fun getHomeComponentUseCase(): GetHomeUseCase {
        return KoinPlatform.getKoin().get<GetHomeUseCase>()
    }
}

