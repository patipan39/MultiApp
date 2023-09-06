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
            val playerItem = AVPlayerItem(NSURL.fileURLWithPath(uri))
            avPlayer = AVPlayer(playerItem)
            avPlayer?.let {
                it.setVolume(1.0f)
                it.setAllowsExternalPlayback(true)
                it.play()
            }
        }
    }
}