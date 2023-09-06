package com.dev.ipati.multiapp.res

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.dev.ipati.multiapp.R

actual object PainterRes {
    @Composable
    actual fun iconBack(): Painter = painterResource(R.drawable.ic_back)

    @Composable
    actual fun iconHeart(): Painter = painterResource(R.drawable.ic_heart)

    @Composable
    actual fun iconMenu(): Painter = painterResource(R.drawable.ic_menu)

    @Composable
    actual fun iconShare(): Painter = painterResource(R.drawable.ic_share)

    @Composable
    actual fun iconDots(): Painter = painterResource(R.drawable.ic_dots)

    @Composable
    actual fun iconSubTitle(): Painter = painterResource(R.drawable.ic_subtitle)

    @Composable
    actual fun iconPrevious(): Painter = painterResource(R.drawable.ic_previous)

    @Composable
    actual fun iconNext(): Painter = painterResource(R.drawable.ic_next)
}