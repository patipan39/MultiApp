package com.dev.ipati.multiapp.res

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

expect object PainterRes {
    @Composable
    fun iconBack(): Painter

    @Composable
    fun iconHeart(): Painter

    @Composable
    fun iconMenu(): Painter

    @Composable
    fun iconShare(): Painter

    @Composable
    fun iconDots(): Painter

    @Composable
    fun iconSubTitle(): Painter

    @Composable
    fun iconPrevious(): Painter

    @Composable
    fun iconNext(): Painter

    @Composable
    fun iconRepeat(): Painter

    @Composable
    fun iconSetting(): Painter

    @Composable
    fun iconText(): Painter

    @Composable
    fun iconTimer(): Painter

    @Composable
    fun iconShuffle(): Painter

    @Composable
    fun iconPlay(): Painter

    @Composable
    fun iconPause(): Painter
}