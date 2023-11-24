package com.dev.ipati.multiapp

import androidx.compose.ui.window.ComposeUIViewController
import com.dev.ipati.multiapp.compose.BaseTheme
import com.dev.ipati.multiapp.compose.home.Home

fun homeViewController(
    onClickAlbum: (() -> Unit),
    onClickProfile: (() -> Unit)
) = ComposeUIViewController {
    BaseTheme {
        Home(onClickAlbum, onClickProfile)
    }
}