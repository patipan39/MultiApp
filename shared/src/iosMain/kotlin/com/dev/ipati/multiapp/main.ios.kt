package com.dev.ipati.multiapp

import androidx.compose.ui.window.ComposeUIViewController
import com.dev.ipati.multiapp.compose.main.App
import com.dev.ipati.multiapp.compose.BaseTheme
import platform.UIKit.UIViewController

fun mainViewController(onBack: (() -> Unit)): UIViewController = ComposeUIViewController {
    BaseTheme {
        App(onBack)
    }
}