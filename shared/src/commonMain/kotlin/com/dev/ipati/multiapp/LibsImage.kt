package com.dev.ipati.multiapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

expect object LibsImage {
    @Composable
    fun KamelImage(modifier: Modifier = Modifier, url: String)
}