package com.dev.ipati.multiapp.media

expect object MediaPlayer {
    fun play(uri: String)

    fun isPlaying() : Boolean
}