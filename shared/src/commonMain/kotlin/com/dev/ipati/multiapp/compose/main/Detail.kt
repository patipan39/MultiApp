package com.dev.ipati.multiapp.compose.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.unit.dp
import com.dev.ipati.multiapp.media.mediaPlayer
import com.dev.ipati.multiapp.style.FontWeight400
import com.multi.resource.SharedRes
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun Detail() {
    val progress = remember { mutableStateOf(Progress()) }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Kesariya", style = FontWeight400(textSize = 20))
            Spacer(modifier = Modifier.weight(1f))
            Image(
                modifier = Modifier.padding(horizontal = 8.dp),
                painter = painterResource(SharedRes.images.ic_share),
                contentDescription = null
            )
            Image(
                painter = painterResource(SharedRes.images.ic_dots),
                contentDescription = null
            )
        }
        Text(
            text = "Arjit singh",
            style = FontWeight400(textColor = Color(0xFFABABAB), textSize = 14)
        )
        LinearProgressIndicator(
            modifier = Modifier.padding(top = 8.dp)
                .fillMaxWidth()
                .height(11.dp)
                .clip(
                    RoundedCornerShape(16.dp)
                ),
            backgroundColor = Color(0x66F2F2F2),
            color = Color(0xFF7A51E2),
            strokeCap = StrokeCap.Round,
            progress = progress.value.progress / 100
        )
        Row(
            modifier = Modifier.padding(top = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "1:25", style = FontWeight400(
                    textColor = Color(0x99FFFFFF),
                    textSize = 12
                )
            )
            Spacer(Modifier.weight(1f))
            Text(
                text = "3:15", style = FontWeight400(
                    textColor = Color(0x99FFFFFF),
                    textSize = 12
                )
            )
        }
        if (!LocalInspectionMode.current) {
            mediaPlayer().onProgress()
        }
        ControllerPlayer()
    }
}

class Progress(val progress: Float = 0f)