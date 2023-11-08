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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.dev.ipati.multiapp.CommonViewModel
import com.dev.ipati.multiapp.style.FontWeight400
import com.multi.resource.SharedRes
import com.seiko.imageloader.rememberImagePainter
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import dev.icerock.moko.resources.compose.painterResource
import org.koin.mp.KoinPlatform

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ThumbnailCollection(
    onClickedItem: (() -> Unit)? = null
) {
    val viewModel: CommonViewModel = getViewModel(
        Unit, viewModelFactory {
            CommonViewModel(KoinPlatform.getKoin().get())
        })
    val album by viewModel.stateHome
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(album) {
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
                    painter = rememberImagePainter(it.album?.url.orEmpty()),
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
                            text = it.album?.name.orEmpty(),
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
                                text = "${it.track} track",
                                style = FontWeight400(textSize = 12),
                            )
                        }
                    }
                }
            }
        }
    }
}