package com.dev.ipati.multiapp.media

import platform.AVFoundation.AVPlayer
import platform.AVFoundation.AVPlayerItem
import platform.AVFoundation.pause
import platform.AVFoundation.play
import platform.AVFoundation.rate
import platform.AVFoundation.setAllowsExternalPlayback
import platform.AVFoundation.setVolume
import platform.Foundation.NSURL

actual object MediaPlayer {
    var avPlayer: AVPlayer? = null

    actual fun Play(uri: String) {
        if (avPlayer != null && avPlayer?.rate() != 0f) {
            avPlayer?.pause()
        } else {
            avPlayer?.play() ?: run {
                val playerItem = AVPlayerItem(NSURL.fileURLWithPath(uri))
                avPlayer = AVPlayer(playerItem)
                avPlayer?.setVolume(1.0f)
                avPlayer?.setAllowsExternalPlayback(true)
                avPlayer?.play()
            }
        }
    }

    actual fun isPlaying(): Boolean {
        return avPlayer?.let {
            it.rate() != 0f
        } ?: false
    }
}