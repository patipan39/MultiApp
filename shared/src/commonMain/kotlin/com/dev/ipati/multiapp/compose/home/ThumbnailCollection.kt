package com.dev.ipati.multiapp.compose.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.dev.ipati.multiapp.style.FontWeight400
import com.multi.resource.SharedRes
import com.seiko.imageloader.rememberImagePainter
import dev.icerock.moko.resources.compose.painterResource

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ThumbnailCollection(onClickedItem: (() -> Unit)? = null) {
    val listThumbnail = mutableListOf("Item", "Item", "Item", "Item", "Item")
    val image = rememberImagePainter(
        "https://www.khaosod.co.th/wpapp/uploads/2023/06/ent15p1-6.jpg"
    )
    LazyRow(
        modifier = Modifier.padding(vertical = 16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(listThumbnail) {
            Surface(
                modifier = Modifier.size(165.dp, 180.dp),
                shape = RoundedCornerShape(25.dp),
                color = Color.Transparent,
                contentColor = Color.Transparent,
                onClick = {
                    onClickedItem?.invoke()
                }
            ) {
                Image(
                    painter = image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .size(149.dp, 50.dp)
                            .background(
                                brush = Brush.linearGradient(
                                    colors = listOf(
                                        Color.DarkGray,
                                        Color.DarkGray,
                                        Color.DarkGray
                                    )
                                ),
                                shape = RoundedCornerShape(15.dp),
                                alpha = 0.4f
                            ),
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            text = it,
                            style = FontWeight400(textSize = 12)
                        )

                        Row(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            horizontalArrangement = Arrangement.spacedBy(2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                modifier = Modifier
                                    .wrapContentSize()
                                    .size(12.dp, 12.dp),
                                painter = painterResource(SharedRes.images.ic_music),
                                contentDescription = null
                            )
                            Text(
                                modifier = Modifier,
                                text = "22 tracks",
                                style = FontWeight400(textSize = 12),
                            )
                        }
                    }
                }
            }
        }
    }
}