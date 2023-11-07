package com.dev.ipati.multiapp

import com.dev.ipati.multiapp.data.AlbumResponse

sealed class Result<T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error<T>(val e: Exception) : Result<T>()
}

interface GetAlbumUseCase {
    suspend fun execute(): Result<AlbumResponse>
}

class GetAlbumUseCaseImpl(
    private val repository: GetAlbumRepository
) : GetAlbumUseCase {
    override suspend fun execute(): Result<AlbumResponse> {
        return try {
            val data = repository.getAlbum()
            Result.Success(data)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}
