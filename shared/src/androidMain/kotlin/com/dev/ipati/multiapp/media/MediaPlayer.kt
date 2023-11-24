package com.dev.ipati.multiapp.media

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import kotlinx.coroutines.delay
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@UnstableApi
actual object MediaPlayer : KoinComponent {
    private val exoPlayer: ExoPlayer by inject()

    init {
        exoPlayer.currentMediaItem ?: run {
            val mediaItem = MediaItem.fromUri(
                //Todo: implement url music
                ""
            )
            exoPlayer.setMediaItem(mediaItem)
            exoPlayer.prepare()
        }
    }

    actual fun play(uri: String) {
        if (!exoPlayer.isPlaying) {
            exoPlayer.play()
        } else {
            exoPlayer.pause()
        }
    }

    actual fun isPlaying(): Boolean = exoPlayer.isPlaying

    @Composable
    actual fun onProgress(progress: ((Float)) -> Unit) {
        LaunchedEffect(exoPlayer.playbackState == Player.STATE_BUFFERING) {
            while (true) {
                delay(1000L)
                if (exoPlayer.playbackState == Player.STATE_ENDED) {
                    progress(0f)
                    break
                } else {
                    progress((exoPlayer.currentPosition * 100) / exoPlayer.duration.toFloat())
                }
            }
        }
    }
}