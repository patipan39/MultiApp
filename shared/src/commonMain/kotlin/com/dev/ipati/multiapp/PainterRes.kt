package com.dev.ipati.multiapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

expect object PainterRes {
    @Composable
    fun iconBack(): Painter

    @Composable
    fun iconHeart(): Painter

    @Composable
    fun iconMenu(): Painter
}