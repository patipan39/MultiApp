package com.dev.ipati.multiapp

import com.dev.ipati.multiapp.data.ProfileData
import com.dev.ipati.multiapp.data.ProfileResponse
import com.dev.ipati.multiapp.data.repository.GetHomeRepository
import com.dev.ipati.multiapp.usecase.GetProfileUseCase
import com.dev.ipati.multiapp.usecase.GetProfileUseCaseImpl
import io.mockative.Mock
import io.mockative.classOf
import io.mockative.coEvery
import io.mockative.mock
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class MainTest {

    @Mock
    lateinit var repository: GetHomeRepository
    private lateinit var getProfileUseCase: GetProfileUseCase

    @BeforeTest
    fun before() {
        repository = mock(classOf<GetHomeRepository>())
        getProfileUseCase = GetProfileUseCaseImpl(repository)
    }

    @Test
    fun shouldMatchProfilePage() = runTest {
        coEvery {
            repository.getProfile()
        }.returns(mockProfileResponse)

        when (val result = getProfileUseCase.execute()) {
            is Result.Success -> {
                assertEquals(result.data.currentProfile, emptyList())
                assertEquals(result.data.otherProfile, listOf(mockOtherProfile))
            }

            else -> {
                assertEquals(false, true, message = "should be success case")
            }
        }
    }

    companion object {
        private val mockOtherProfile: ProfileData.Info =
            ProfileData.Info("www.google.com", name = "name", channelName = "Facebook")

        private val mockProfileResponse = ProfileResponse(
            status = "success",
            message = "success",
            data = ProfileData(currentProfile = emptyList(), otherProfile = listOf(mockOtherProfile))
        )
    }
}