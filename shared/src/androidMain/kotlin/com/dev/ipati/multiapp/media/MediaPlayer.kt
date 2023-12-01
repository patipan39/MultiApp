package com.dev.ipati.multiapp.media

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.core.net.toUri
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import kotlinx.coroutines.delay
import org.koin.mp.KoinPlatform

class MediaPlayerImpl : IMediaPlayer {

    private val exoPlayer: ExoPlayer = KoinPlatform.getKoin().get()

    override fun onPlay() {
        if (!exoPlayer.isPlaying) {
            exoPlayer.play()
        } else {
            exoPlayer.pause()
        }
    }

    override fun isPlaying(): Boolean = exoPlayer.isPlaying

    @Composable
    override fun onProgress() {
        LaunchedEffect(exoPlayer.playbackState == Player.STATE_BUFFERING) {
            while (true) {
                delay(1000L)
                if (exoPlayer.playbackState == Player.STATE_ENDED) {
//                    progress(0f)
                    break
                } else {
//                    progress((exoPlayer.currentPosition * 100) / exoPlayer.duration.toFloat())
                }
            }
        }
    }

    override fun setAlbumId(id: String) {
        exoPlayer.currentMediaItem ?: run {
            val mediaItem = MediaItem.fromUri(
                "https://drive.google.com/uc?export=open&id=${id}".toUri()
            )
            exoPlayer.setMediaItem(mediaItem)
            exoPlayer.prepare()
        }
    }
}

actual fun mediaPlayer(): IMediaPlayer = KoinPlatform.getKoin().get()