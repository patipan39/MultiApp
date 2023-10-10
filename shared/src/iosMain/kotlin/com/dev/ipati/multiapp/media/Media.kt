package com.dev.ipati.multiapp.media

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import platform.AVFoundation.AVPlayerItem
import platform.AVFoundation.pause
import platform.AVFoundation.play
import platform.AVFoundation.rate
import platform.AVFoundation.replaceCurrentItemWithPlayerItem
import platform.Foundation.NSURL

actual object MediaPlayer : KoinComponent {
    private val mediaWrapper: MediaWrapper by inject()

    actual fun play(uri: String) {
        val playerItem = AVPlayerItem(NSURL.fileURLWithPath(uri))
        mediaWrapper.getAVPlayer().replaceCurrentItemWithPlayerItem(playerItem)
        if (mediaWrapper.getAVPlayer().rate() != 0f) {
            mediaWrapper.getAVPlayer().pause()
        } else {
            mediaWrapper.getAVPlayer().play()
        }
    }

    actual fun isPlaying(): Boolean {
        return mediaWrapper.getAVPlayer().rate() != 0f
    }
}