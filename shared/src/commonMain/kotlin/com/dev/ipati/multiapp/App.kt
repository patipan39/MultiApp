package com.dev.ipati.multiapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dev.ipati.multiapp.style.FontWeight400

@Composable
fun App() {
    Column(
        Modifier.fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.Black,
                        Color(0x877A51E2)
                    )
                )
            )
    ) {
        AppToolbar()
    }
}

@Composable
fun AppToolbar() {
    Row(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 16.dp, top = 60.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Box(modifier = Modifier.align(Alignment.CenterVertically).weight(1f)) {
            Image(
                modifier = Modifier,
                painter = PainterRes.iconBack(),
                contentDescription = null
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth().weight(2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                modifier = Modifier,
                text = "Now playing",
                style = FontWeight400()
            )
            Text(
                modifier = Modifier,
                text = "Playlist of the day",
                style = FontWeight400()
            )
        }

        Row(
            modifier = Modifier.align(Alignment.CenterVertically).weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Image(
                modifier = Modifier.padding(end = 8.dp),
                painter = PainterRes.iconHeart(),
                contentDescription = null,
                alignment = Alignment.CenterEnd
            )
            Image(
                painter = PainterRes.iconMenu(),
                contentDescription = null,
                alignment = Alignment.CenterEnd
            )
        }
    }
}

@Composable
fun Thumbnail() {

}