package com.dev.ipati.multiapp.style

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.dev.ipati.multiapp.R

actual object FontRes {
    @Composable
    actual fun fontInterLight(): FontFamily = FontFamily(Font(R.font.inter_light))
}