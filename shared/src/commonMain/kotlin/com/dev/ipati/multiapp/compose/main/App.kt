package com.dev.ipati.multiapp.compose.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dev.ipati.multiapp.LibsImage
import com.dev.ipati.multiapp.style.FontWeight400
import com.multi.resource.SharedRes
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun App(onBack: (() -> Unit)? = null) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        AppToolbar(onBack)
        Thumbnail()
        BottomMenu()
    }
}

@Composable
fun AppToolbar(onBack: (() -> Unit)? = null) {
    Row(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Box(modifier = Modifier.weight(1f).align(Alignment.CenterVertically)) {
            IconButton(onClick = {
                onBack?.invoke()
            }) {
                Image(
                    painter = painterResource(SharedRes.images.ic_back),
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
                painter = painterResource(SharedRes.images.ic_heart),
                contentDescription = null,
                alignment = Alignment.CenterEnd
            )
            Image(
                painter = painterResource(SharedRes.images.ic_menu),
                contentDescription = null,
                alignment = Alignment.CenterEnd
            )
        }
    }
}

@Composable
fun Thumbnail() {
    Column {
        Box(modifier = Modifier.fillMaxWidth()) {
            Card(
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.Center)
                    .clip(RoundedCornerShape(14.dp)),
                backgroundColor = Color(0x66F2F2F2)
            ) {
                val modifier = Modifier
                    .width(266.dp)
                    .height(268.dp)
                LibsImage.KamelImage(
                    modifier,
                    "https://www.khaosod.co.th/wpapp/uploads/2023/06/ent15p1-6.jpg"
                )
            }
        }
        Detail()
    }
}