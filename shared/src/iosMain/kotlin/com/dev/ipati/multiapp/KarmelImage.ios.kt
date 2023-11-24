package com.dev.ipati.multiapp

import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.ComposeUIViewController

fun karmelImage(url: String) = ComposeUIViewController {
    libsImage().KamelImage(
        modifier = Modifier
            .background(Color.Transparent), url = url
    )
}