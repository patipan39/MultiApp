package com.dev.ipati.multiapp

import androidx.compose.ui.window.ComposeUIViewController
import com.dev.ipati.multiapp.compose.BaseTheme
import com.dev.ipati.multiapp.compose.home.Home
import com.dev.ipati.multiapp.viewmodel.CommonViewModel
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import org.koin.mp.KoinPlatform

fun homeViewController(
    onClickAlbum: (() -> Unit),
    onClickProfile: (() -> Unit)
) = ComposeUIViewController {

    val viewModel: CommonViewModel = getViewModel(
        Unit,
        viewModelFactory { CommonViewModel(KoinPlatform.getKoin().get()) }
    )

    BaseTheme {
        Home(
            viewModel = viewModel,
            onClickAlbum = onClickAlbum,
            onClickProfile = onClickProfile
        )
    }
}