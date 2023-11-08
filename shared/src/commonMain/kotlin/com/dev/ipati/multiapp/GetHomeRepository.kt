package com.dev.ipati.multiapp

import com.dev.ipati.multiapp.data.HomeResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

interface GetHomeRepository {
    suspend fun getHome(): HomeResponse
}

class GetHomeRepositoryImpl(
    private val client: HttpClient
) : GetHomeRepository {
    override suspend fun getHome(): HomeResponse {
        return client.get("/home").body()
    }
}