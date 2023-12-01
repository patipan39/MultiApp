package com.dev.ipati.multiapp.media

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.delay
import org.koin.mp.KoinPlatform
import platform.AVFoundation.*
import platform.CoreMedia.CMTimeGetSeconds
import platform.Foundation.NSURL


class MediaPlayerImpl : IMediaPlayer {

    private val mediaWrapper: MediaWrapper = KoinPlatform.getKoin().get()

    init {
        val playerItem =
            NSURL.URLWithString("https://drive.google.com/uc?export=open&id=15qj-hsjErmddGDHeYyByNoHlyabiG7kI")
                ?.let { AVPlayerItem(it) }
        mediaWrapper.getAVPlayer().currentItem ?: run {
            mediaWrapper.getAVPlayer().replaceCurrentItemWithPlayerItem(playerItem)
        }
    }

    override fun onPlay() {
        if (isPlaying()) {
            mediaWrapper.getAVPlayer().pause()
        } else {
            mediaWrapper.getAVPlayer().play()
        }
    }

    override fun isPlaying(): Boolean {
        return mediaWrapper.getAVPlayer().rate != 0f
                && mediaWrapper.getAVPlayer().error == null
    }

    @OptIn(ExperimentalForeignApi::class)
    @Composable
    override fun onProgress() {
        val player = mediaWrapper.getAVPlayer()
        LaunchedEffect(isPlaying()) {
            while (true) {
                delay(1000L)
                player.currentItem?.let {
                    val duration = CMTimeGetSeconds(it.duration)
                    val time = CMTimeGetSeconds(it.currentTime())
                    val updateProgress =
                        ((time * 100) / duration).toFloat()
//                    progress(updateProgress)
                } ?: run {
//                    progress(0f)
                }
            }
        }
    }

    override fun setAlbumId(id: String) {
        
    }

}

actual fun mediaPlayer(): IMediaPlayer = KoinPlatform.getKoin().get()