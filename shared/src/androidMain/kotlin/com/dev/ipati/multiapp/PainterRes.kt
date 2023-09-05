package com.dev.ipati.multiapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

actual object PainterRes {
    @Composable
    actual fun iconBack(): Painter = painterResource(R.drawable.ic_back)

    @Composable
    actual fun iconHeart(): Painter = painterResource(R.drawable.ic_heart)

    @Composable
    actual fun iconMenu(): Painter = painterResource(R.drawable.ic_menu)
}