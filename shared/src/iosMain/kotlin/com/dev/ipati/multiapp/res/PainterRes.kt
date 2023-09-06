package com.dev.ipati.multiapp.res

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
actual object PainterRes {
    @Composable
    actual fun iconBack(): Painter = painterResource("drawable/ic_back.xml")

    @Composable
    actual fun iconHeart(): Painter = painterResource("drawable/ic_heart.xml")

    @Composable
    actual fun iconMenu(): Painter = painterResource("drawable/ic_menu.xml")

    @Composable
    actual fun iconShare(): Painter = painterResource("drawable/ic_share.xml")

    @Composable
    actual fun iconDots(): Painter = painterResource("drawable/ic_dots.xml")
}