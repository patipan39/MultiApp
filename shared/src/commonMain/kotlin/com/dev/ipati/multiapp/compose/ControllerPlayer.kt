package com.dev.ipati.multiapp.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dev.ipati.multiapp.res.PainterRes

@Composable
fun ControllerPlayer() {
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = PainterRes.iconSubTitle(), contentDescription = null)
        Spacer(Modifier.weight(1f))
        Image(painter = PainterRes.iconPrevious(), contentDescription = null)
        Spacer(Modifier.weight(1f))
        Card(
            modifier = Modifier
                .width(74.dp)
                .height(74.dp)
                .background(Color.Transparent)
                .clip(RoundedCornerShape(50)),
            backgroundColor = Color(0xFF7A51E2),
            shape = RoundedCornerShape(50)
        ) {
            Row(
                modifier = Modifier.padding(vertical = 21.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally)
            ) {
                Card(
                    modifier = Modifier.width(7.dp)
                        .fillMaxHeight(),
                    backgroundColor = Color(0xFF383344)
                ) {

                }

                Card(
                    modifier = Modifier.width(7.dp)
                        .fillMaxHeight(),
                    backgroundColor = Color(0xFF383344)
                ) {

                }
            }
        }
        Spacer(Modifier.weight(1f))
        Image(painter = PainterRes.iconNext(), contentDescription = null)
        Spacer(Modifier.weight(1f))
        Spacer(Modifier.size(25.dp))
    }
}