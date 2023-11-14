package com.dev.ipati.multiapp.usecase

import com.dev.ipati.multiapp.Result
import com.dev.ipati.multiapp.data.ProfileData


interface GetProfileUseCase {
    fun execute(): Result<ProfileData>
}

class GetProfileUseCaseImpl() : GetProfileUseCase {
    override fun execute(): Result<ProfileData> {
        return Result.Success(
            ProfileData(
                currentProfile = listOf(mapCurrentProfile()),
                otherProfile = mapOtherProfile()
            )
        )
    }

    private fun mapCurrentProfile(): ProfileData.Info {
        return ProfileData.Info(
            imageUrl = "https://cdn-icons-png.flaticon.com/512/3135/3135715.png",
            channelName = "Facebook"
        )
    }

    private fun mapOtherProfile(): List<ProfileData.Info> {
        return listOf(
            ProfileData.Info(
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e7/Instagram_logo_2016.svg/2048px-Instagram_logo_2016.svg.png",
                channelName = "Intragram",
                description = "John Deep"
            ),
            ProfileData.Info(
                imageUrl = "https://img.freepik.com/premium-vector/tik-tok-logo_578229-290.jpg",
                channelName = "Tick Tok",
                description = "John Deep"
            ),
            ProfileData.Info(
                imageUrl = "https://static.dezeen.com/uploads/2023/07/x-logo-twitter-elon-musk_dezeen_2364_col_0-1.jpg",
                channelName = "Twitter",
                description = "John Deep"
            )
        )
    }
}