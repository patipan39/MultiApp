package com.dev.ipati.multiapp.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AlbumResponse(
    @SerialName("status") val name: String? = null,
    @SerialName("message") val message: String? = null,
    @SerialName("data") val data: Data? = null
) {
    @Serializable
    data class Data(
        val id: String? = null,
        val name: String? = null,
        val year: String? = null,
        val releaseDate: String? = null,
        val uri: String? = null,
        val primaryArtistsId: String? = null,
        val primaryArtists: String? = null,
        @SerialName("songs") val songList: List<Song>? = null
    )

    @Serializable
    data class Song(
        val id: String? = null,
        val name: String? = null,
        val album: Album? = null,
        val track: Int? = null
    )

    @Serializable
    data class Album(
        val url: String? = null,
        val name: String? = null
    )
}