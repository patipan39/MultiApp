package com.dev.ipati.multiapp.media

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import platform.AVFoundation.AVPlayer
import platform.AVFoundation.AVPlayerItem
import platform.AVFoundation.pause
import platform.AVFoundation.play
import platform.AVFoundation.rate
import platform.AVFoundation.replaceCurrentItemWithPlayerItem
import platform.Foundation.NSURL

actual object MediaPlayer : KoinComponent {
    private val avPlayer: AVPlayer by inject()

    actual fun play(uri: String) {
        val playerItem = AVPlayerItem(NSURL.fileURLWithPath(uri))
        avPlayer.replaceCurrentItemWithPlayerItem(playerItem)
        if (avPlayer.rate() != 0f) {
            avPlayer.pause()
        } else {
            avPlayer.play()
        }
    }

    actual fun isPlaying(): Boolean {
        return avPlayer.rate() != 0f
    }
}