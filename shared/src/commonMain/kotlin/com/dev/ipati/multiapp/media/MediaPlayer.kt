package com.dev.ipati.multiapp.media

import androidx.compose.runtime.Composable

interface IMediaPlayer {
    fun onPlay()
    fun isPlaying(): Boolean

    @Composable
    fun onProgress()

    fun setAlbumId(id: String)
}

expect fun mediaPlayer(): IMediaPlayer