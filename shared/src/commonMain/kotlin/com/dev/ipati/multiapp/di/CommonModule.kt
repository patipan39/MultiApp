package com.dev.ipati.multiapp.di

import com.dev.ipati.multiapp.GetAlbumRepository
import com.dev.ipati.multiapp.GetAlbumRepositoryImpl
import com.dev.ipati.multiapp.GetAlbumUseCase
import com.dev.ipati.multiapp.GetAlbumUseCaseImpl
import com.dev.ipati.multiapp.service.KtorService
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

val commonModule = module {
    factory {
        KtorService.client()
    }

    factoryOf(::GetAlbumRepositoryImpl) bind GetAlbumRepository::class

    factoryOf(::GetAlbumUseCaseImpl) bind GetAlbumUseCase::class
}