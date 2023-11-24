package com.dev.ipati.multiapp.data.repository

import com.dev.ipati.multiapp.data.HomeResponse
import com.dev.ipati.multiapp.data.ProfileResponse
import com.dev.ipati.multiapp.service.IKtorService
import io.ktor.client.call.*
import io.ktor.client.request.*

interface GetHomeRepository {
    suspend fun getHome(): HomeResponse
    suspend fun getProfile(): ProfileResponse
}

class GetHomeRepositoryImpl(
    private val ktorService: IKtorService
) : GetHomeRepository {
    override suspend fun getHome(): HomeResponse {
        return ktorService.client.get("/home").body()
    }

    override suspend fun getProfile(): ProfileResponse {
        return ktorService.client.get("/profile").body()
    }
}