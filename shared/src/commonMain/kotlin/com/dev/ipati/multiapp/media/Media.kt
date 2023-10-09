package com.dev.ipati.multiapp.media

expect object MediaPlayer {
    fun Play(uri: String)

    fun isPlaying() : Boolean
}