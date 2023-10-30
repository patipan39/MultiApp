package com.dev.ipati.multiapp.style

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.multi.resource.SharedRes
import dev.icerock.moko.resources.compose.fontFamilyResource

@Composable
fun FontWeight400(textColor: Color = Color.White, textSize: Int): TextStyle {
    return TextStyle(
        color = textColor,
        fontWeight = FontWeight(400),
        fontFamily = fontFamilyResource(SharedRes.fonts.inter_light.inter_light),
        fontSize = textSize.sp
    )
}