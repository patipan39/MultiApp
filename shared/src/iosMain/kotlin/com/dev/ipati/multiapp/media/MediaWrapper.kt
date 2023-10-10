package com.dev.ipati.multiapp.media

import platform.AVFoundation.AVPlayer
import platform.AVFoundation.setAllowsExternalPlayback
import platform.AVFoundation.setVolume

class MediaWrapper {
    fun getAVPlayer() = avPlayer

    companion object {
        private val avPlayer: AVPlayer = AVPlayer().apply {
            setVolume(1.0f)
            setAllowsExternalPlayback(true)
        }
    }
}