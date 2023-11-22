package com.dev.ipati.multiapp.di

import com.dev.ipati.multiapp.data.repository.GetHomeRepository
import com.dev.ipati.multiapp.data.repository.GetHomeRepositoryImpl
import com.dev.ipati.multiapp.usecase.GetHomeUseCase
import com.dev.ipati.multiapp.usecase.GetHomeUseCaseImpl
import com.dev.ipati.multiapp.service.KtorService
import com.dev.ipati.multiapp.usecase.GetProfileUseCase
import com.dev.ipati.multiapp.usecase.GetProfileUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val commonModule = module {
    factory {
        KtorService.client()
    }

    factoryOf(::GetHomeRepositoryImpl) bind GetHomeRepository::class

    factoryOf(::GetHomeUseCaseImpl) bind GetHomeUseCase::class

    factoryOf(::GetProfileUseCaseImpl) bind GetProfileUseCase::class
}