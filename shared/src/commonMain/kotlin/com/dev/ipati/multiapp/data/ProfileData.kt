package com.dev.ipati.multiapp.data

data class ProfileData(
    val currentProfile: List<Info>?,
    val otherProfile : List<Info>?
) {
    data class Info(
        val imageUrl: String,
        val channelName: String,
        val description: String? = null
    )
}