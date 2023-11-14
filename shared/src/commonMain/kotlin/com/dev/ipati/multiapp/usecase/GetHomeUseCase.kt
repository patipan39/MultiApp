package com.dev.ipati.multiapp.usecase

import com.dev.ipati.multiapp.GetHomeRepository
import com.dev.ipati.multiapp.data.HomeResponse
import com.dev.ipati.multiapp.Result

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
