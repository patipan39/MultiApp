package com.dev.ipati.multiapp

import androidx.compose.ui.window.ComposeUIViewController
import com.dev.ipati.multiapp.compose.App
import platform.UIKit.UIViewController

fun MainViewController(onBack: (() -> Unit)): UIViewController = ComposeUIViewController {
    App(onBack)
}