package com.dev.ipati.multiapp

sealed class Result {
    data object Success : Result()
    data object Error : Result()
}

interface GetAlbumUseCase {
    suspend fun execute(): Result
}

class GetAlbumUseCaseImpl : GetAlbumUseCase {
    override suspend fun execute(): Result {
        return Result.Success
    }
}
