package com.dev.ipati.multiapp.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfileData(
    @SerialName("currentProfile") val currentProfile: List<Info>,
    @SerialName("otherProfile") val otherProfile: List<Info>
) {
    @Serializable
    data class Info(
        @SerialName("avatar") val imageUrl: String,
        @SerialName("name") val name: String,
        @SerialName("channelName") val channelName: String,
        val description: String? = null
    )
}