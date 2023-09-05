package com.dev.ipati.multiapp.style

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.platform.Typeface
import androidx.compose.ui.text.platform.toSkFontStyle
import org.jetbrains.skia.Typeface

actual object FontRes {
    @Composable
    actual fun fontInterLight(): FontFamily {
        return FontFamily(
            Typeface(
                Typeface.makeFromName(
                    "font/inter_light.ttf", FontStyle.Normal.toSkFontStyle()
                )
            )
        )
    }
}