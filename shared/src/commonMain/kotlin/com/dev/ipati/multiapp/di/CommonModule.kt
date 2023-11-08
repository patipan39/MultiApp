package com.dev.ipati.multiapp.di

import com.dev.ipati.multiapp.GetHomeRepository
import com.dev.ipati.multiapp.GetHomeRepositoryImpl
import com.dev.ipati.multiapp.GetHomeUseCase
import com.dev.ipati.multiapp.GetHomeUseCaseImpl
import com.dev.ipati.multiapp.service.KtorService
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val commonModule = module {
    factory {
        KtorService.client()
    }

    factoryOf(::GetHomeRepositoryImpl) bind GetHomeRepository::class

    factoryOf(::GetHomeUseCaseImpl) bind GetHomeUseCase::class
}