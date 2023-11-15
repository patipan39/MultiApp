package com.dev.ipati.multiapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ComposeUIViewController

fun KarmelImage(url: String) = ComposeUIViewController {
    LibsImage.KamelImage(
        modifier = Modifier.size(128.dp, 128.dp)
            .background(Color.Transparent), url = url
    )
}