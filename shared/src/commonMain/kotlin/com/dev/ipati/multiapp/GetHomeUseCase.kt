package com.dev.ipati.multiapp

import com.dev.ipati.multiapp.data.HomeResponse

sealed class Result<T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error<T>(val e: Exception) : Result<T>()
}

interface GetHomeUseCase {
    suspend fun execute(): Result<HomeResponse>
}

class GetHomeUseCaseImpl(
    private val repository: GetHomeRepository
) : GetHomeUseCase {
    override suspend fun execute(): Result<HomeResponse> {
        return try {
            val data = repository.getHome()
            Result.Success(data)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}
