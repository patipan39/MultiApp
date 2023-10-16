package com.dev.ipati.multiapp.media

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.delay
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import platform.AVFoundation.AVPlayerItem
import platform.AVFoundation.currentItem
import platform.AVFoundation.currentTime
import platform.AVFoundation.duration
import platform.AVFoundation.pause
import platform.AVFoundation.play
import platform.AVFoundation.rate
import platform.AVFoundation.replaceCurrentItemWithPlayerItem
import platform.CoreMedia.CMTimeGetSeconds
import platform.Foundation.NSLog
import platform.Foundation.NSURL

actual object MediaPlayer : KoinComponent {
    private val mediaWrapper: MediaWrapper by inject()

    actual fun play(uri: String) {
        val playerItem = AVPlayerItem(NSURL.fileURLWithPath(uri))
        mediaWrapper.getAVPlayer().currentItem ?: run {
            mediaWrapper.getAVPlayer().replaceCurrentItemWithPlayerItem(playerItem)
        }
        if (isPlaying()) {
            mediaWrapper.getAVPlayer().pause()
        } else {
            mediaWrapper.getAVPlayer().play()
        }
    }

    actual fun isPlaying(): Boolean {
        return mediaWrapper.getAVPlayer().rate != 0f
                && mediaWrapper.getAVPlayer().error == null
    }

    @OptIn(ExperimentalForeignApi::class)
    @Composable
    actual fun onProgress(progress: (Float) -> Unit) {
        val player = mediaWrapper.getAVPlayer()
        LaunchedEffect(isPlaying()) {
            while (true) {
                delay(1000L)
                player.currentItem?.let {
                    val duration = CMTimeGetSeconds(it.duration)
                    val time = CMTimeGetSeconds(it.currentTime())
                    val updateProgress =
                        ((time * 100) / duration).toFloat()
                    progress(updateProgress)
                } ?: run {
                    progress(0f)
                }
            }
        }
    }
}