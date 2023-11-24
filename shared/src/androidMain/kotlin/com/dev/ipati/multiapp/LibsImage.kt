package com.dev.ipati.multiapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import io.ktor.http.Url

class LibsImageImpl : ILibsImage {
    @Composable
    override fun KamelImage(modifier: Modifier, url: String) {
        KamelImage(
            modifier = Modifier.then(modifier),
            resource = asyncPainterResource(Url(url)),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}

actual fun libsImage(): ILibsImage = LibsImageImpl()