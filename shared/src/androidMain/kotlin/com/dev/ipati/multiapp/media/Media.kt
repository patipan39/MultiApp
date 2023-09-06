package com.dev.ipati.multiapp.media

import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.RawResourceDataSource
import androidx.media3.exoplayer.ExoPlayer
import com.dev.ipati.multiapp.R
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.parameter.parametersOf

@UnstableApi
actual object MediaPlayer : KoinComponent {
    actual fun Play(uri: String) {
        val exoPlayer = get<ExoPlayer> {
            parametersOf(
                MediaItem.fromUri(
                    RawResourceDataSource.buildRawResourceUri(
                        R.raw.first_love
                    )
                )
            )
        }
        if (!exoPlayer.isPlaying) {
            exoPlayer.play()
        } else {
            exoPlayer.pause()
        }
    }
}