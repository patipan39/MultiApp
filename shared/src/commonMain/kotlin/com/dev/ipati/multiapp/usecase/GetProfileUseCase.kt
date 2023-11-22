package com.dev.ipati.multiapp.usecase

import com.dev.ipati.multiapp.Result
import com.dev.ipati.multiapp.data.ProfileData
import com.dev.ipati.multiapp.data.repository.GetHomeRepository


interface GetProfileUseCase {
    suspend fun execute(): Result<ProfileData>
}

class GetProfileUseCaseImpl(
    private val repository: GetHomeRepository
) : GetProfileUseCase {
    override suspend fun execute(): Result<ProfileData> {
        return try {
            val result = repository.getProfile()
            result.data?.let {
                Result.Success(it)
            } ?: Result.Error(Exception("The Empty Profile"))
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}
