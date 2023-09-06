package com.dev.ipati.multiapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.dev.ipati.multiapp.compose.BottomMenu
import com.dev.ipati.multiapp.compose.Detail
import com.dev.ipati.multiapp.res.PainterRes
import com.dev.ipati.multiapp.style.FontWeight400
import com.seiko.imageloader.rememberImagePainter

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
            ),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        AppToolbar()
        Thumbnail()
        BottomMenu()
    }
}

@Composable
fun AppToolbar() {
    Row(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Box(modifier = Modifier.weight(1f).align(Alignment.CenterVertically)) {
            IconButton(onClick = {
                //handle click
            }) {
                Image(
                    painter = PainterRes.iconBack(),
                    contentDescription = null
                )
            }
        }

        Column(
            modifier = Modifier.fillMaxWidth().weight(2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                modifier = Modifier,
                text = "Now playing",
                style = FontWeight400(textSize = 12)
            )
            Text(
                modifier = Modifier,
                text = "Playlist of the day",
                style = FontWeight400(textSize = 13)
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
    val image = rememberImagePainter(
        "https://www.khaosod.co.th/wpapp/uploads/2023/06/ent15p1-6.jpg"
    )
    Column {
        Box(modifier = Modifier.fillMaxWidth()) {
            Card(
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.Center)
                    .clip(RoundedCornerShape(14.dp)),
                backgroundColor = Color(0x66F2F2F2)
            ) {
                Image(
                    modifier = Modifier
                        .width(266.dp)
                        .height(268.dp),
                    painter = image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
        }
        Detail()
    }
}