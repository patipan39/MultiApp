package com.dev.ipati.multiapp.res

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.koin.core.component.KoinComponent

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

    @Composable
    actual fun iconSubTitle(): Painter = painterResource("drawable/ic_subtitle.xml")

    @Composable
    actual fun iconPrevious(): Painter = painterResource("drawable/ic_previous.xml")

    @Composable
    actual fun iconNext(): Painter = painterResource("drawable/ic_next.xml")

    @Composable
    actual fun iconRepeat(): Painter = painterResource("drawable/ic_repeat.xml")

    @Composable
    actual fun iconSetting(): Painter = painterResource("drawable/ic_settings.xml")

    @Composable
    actual fun iconText(): Painter = painterResource("drawable/ic_text.xml")

    @Composable
    actual fun iconTimer(): Painter = painterResource("drawable/ic_timer.xml")

    @Composable
    actual fun iconShuffle(): Painter = painterResource("drawable/ic_shuffle.xml")

    @Composable
    actual fun iconPlay(): Painter = painterResource("drawable/ic_play.xml")

    @Composable
    actual fun iconPause(): Painter = painterResource("drawable/ic_pause.xml")
}