package com.dev.ipati.multiapp.di

import com.dev.ipati.multiapp.GetAlbumUseCase
import com.dev.ipati.multiapp.GetAlbumUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val commonModule = module {
    factoryOf(::GetAlbumUseCaseImpl) bind GetAlbumUseCase::class
}