package com.dev.ipati.multiapp

import com.dev.ipati.multiapp.data.AlbumResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

interface GetAlbumRepository {
    suspend fun getAlbum(): AlbumResponse
}

class GetAlbumRepositoryImpl(
    private val client: HttpClient
) : GetAlbumRepository {
    override suspend fun getAlbum(): AlbumResponse {
        return client.get("/album").body()
    }
}