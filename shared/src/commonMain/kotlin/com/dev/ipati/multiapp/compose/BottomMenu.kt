package com.dev.ipati.multiapp.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.ipati.multiapp.res.PainterRes

@Composable
fun BottomMenu() {
    Row(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(PainterRes.iconRepeat(), contentDescription = null)
        Spacer(Modifier.weight(1f))
        Image(PainterRes.iconSetting(), contentDescription = null)
        Spacer(Modifier.weight(1f))
        Image(PainterRes.iconText(), contentDescription = null)
        Spacer(Modifier.weight(1f))
        Image(PainterRes.iconTimer(), contentDescription = null)
        Spacer(Modifier.weight(1f))
        Image(PainterRes.iconShuffle(), contentDescription = null)
    }
}