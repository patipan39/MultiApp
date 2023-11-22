package com.dev.ipati.multiapp.data.repository

import com.dev.ipati.multiapp.data.HomeResponse
import com.dev.ipati.multiapp.data.ProfileResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

interface GetHomeRepository {
    suspend fun getHome(): HomeResponse
    suspend fun getProfile(): ProfileResponse
}

class GetHomeRepositoryImpl(
    private val client: HttpClient
) : GetHomeRepository {
    override suspend fun getHome(): HomeResponse {
        return client.get("/home").body()
    }

    override suspend fun getProfile(): ProfileResponse {
        return client.get("/profile").body()
    }
}