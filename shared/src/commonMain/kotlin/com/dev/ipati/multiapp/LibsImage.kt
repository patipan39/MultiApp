package com.dev.ipati.multiapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

interface ILibsImage {
    @Composable
    fun KamelImage(modifier: Modifier, url: String)
}

expect fun libsImage(): ILibsImage