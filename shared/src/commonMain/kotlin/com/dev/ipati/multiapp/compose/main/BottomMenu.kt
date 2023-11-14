package com.dev.ipati.multiapp.compose.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.multi.resource.SharedRes
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun BottomMenu() {
    Row(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(painterResource(SharedRes.images.ic_repeat), contentDescription = null)
        Spacer(Modifier.weight(1f))
        Image(painterResource(SharedRes.images.ic_settings), contentDescription = null)
        Spacer(Modifier.weight(1f))
        Image(painterResource(SharedRes.images.ic_text), contentDescription = null)
        Spacer(Modifier.weight(1f))
        Image(painterResource(SharedRes.images.ic_timer), contentDescription = null)
        Spacer(Modifier.weight(1f))
        Image(painterResource(SharedRes.images.ic_shuffle), contentDescription = null)
    }
}