package com.dev.ipati.multiapp.style

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun FontWeight400(textColor: Color = Color.White, textSize: Int): TextStyle {
    return TextStyle(
        color = textColor,
        fontWeight = FontWeight(400),
        fontFamily = FontRes.fontInterLight(),
        fontSize = textSize.sp
    )
}