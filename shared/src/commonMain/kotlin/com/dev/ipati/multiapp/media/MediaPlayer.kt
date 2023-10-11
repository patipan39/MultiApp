package com.dev.ipati.multiapp.media

import androidx.compose.runtime.Composable

expect object MediaPlayer {
    fun play(uri: String)

    fun isPlaying(): Boolean

    @Composable
    fun onProgress(progress: ((Float) -> Unit))
}