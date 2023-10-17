package com.dev.ipati.multiapp.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.unit.dp
import com.dev.ipati.multiapp.media.MediaPlayer
import com.dev.ipati.multiapp.res.PainterRes

@Composable
fun ControllerPlayer() {
    val inspectionMode = LocalInspectionMode.current
    val isPlayState = remember { mutableStateOf(StatePlayer(false)) }
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = PainterRes.iconSubTitle(), contentDescription = null)
        Spacer(Modifier.weight(1f))
        Image(painter = PainterRes.iconPrevious(), contentDescription = null)
        Spacer(Modifier.weight(1f))
        Card(
            modifier = Modifier
                .width(74.dp)
                .height(74.dp)
                .background(Color.Transparent)
                .clip(RoundedCornerShape(50)),
            backgroundColor = Color(0xFF7A51E2),
            shape = RoundedCornerShape(50)
        ) {
            if (isPlayState.value.isPlay) {
                PauseIcon {
                    val isPlay = if (!inspectionMode) {
                        MediaPlayer.isPlaying()
                    } else {
                        false
                    }
                    isPlayState.value = StatePlayer(isPlay)
                }
            } else {
                PlayIcon {
                    val isPlay = if (!inspectionMode) {
                        MediaPlayer.isPlaying()
                    } else {
                        false
                    }
                    isPlayState.value = StatePlayer(isPlay)
                }
            }
        }
        Spacer(Modifier.weight(1f))
        Image(painter = PainterRes.iconNext(), contentDescription = null)
        Spacer(Modifier.weight(1f))
        Spacer(Modifier.size(25.dp))
    }
}

@Composable
fun PauseIcon(onClicked: ((Boolean) -> Unit)? = null) {
    val isInspectionMode = LocalInspectionMode.current
    Row(
        modifier = Modifier.padding(vertical = 21.dp).clickable {
            if (!isInspectionMode) {
                MediaPlayer.play(
                    "/Users/patipaninjai/AndroidStudioProjects/MultiApp/shared/src/commonMain/resources/raw/first_love.mp3"
                )
            }
            onClicked?.invoke(true)
        },
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = PainterRes.iconPause(),
            modifier = Modifier.fillMaxSize(),
            colorFilter = ColorFilter.tint(Color(0xFF383344)),
            contentDescription = null
        )
    }
}

@Composable
fun PlayIcon(onClicked: ((Boolean) -> Unit)? = null) {
    val isInspectionMode = LocalInspectionMode.current
    Row(
        modifier = Modifier.padding(20.dp)
            .clickable {
                if (!isInspectionMode) {
                    MediaPlayer.play(
                        "/Users/patipaninjai/AndroidStudioProjects/MultiApp/shared/src/commonMain/resources/raw/first_love.mp3"
                    )
                }
                onClicked?.invoke(false)
            },
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = PainterRes.iconPlay(),
            modifier = Modifier.fillMaxSize(),
            colorFilter = ColorFilter.tint(Color(0xFF383344)),
            contentDescription = null
        )
    }
}

class StatePlayer(val isPlay: Boolean)