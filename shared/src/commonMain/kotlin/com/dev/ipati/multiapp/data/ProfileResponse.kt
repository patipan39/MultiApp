package com.dev.ipati.multiapp.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfileResponse(
    val status: String? = null,
    val message: String? = null,
    @SerialName("data") val data: ProfileData? = null
) 