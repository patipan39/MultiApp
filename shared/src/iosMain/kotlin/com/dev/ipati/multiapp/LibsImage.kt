package com.dev.ipati.multiapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.dev.ipati.multiapp.service.ktorService
import io.kamel.core.config.DefaultHttpCacheSize
import io.kamel.core.config.KamelConfig
import io.kamel.core.config.httpFetcher
import io.kamel.core.config.takeFrom
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import io.kamel.image.config.Default
import io.kamel.image.config.LocalKamelConfig
import io.ktor.http.Url

class LibsImageImpl : ILibsImage {
    @Composable
    override fun KamelImage(modifier: Modifier, url: String) {
        val config = KamelConfig {
            takeFrom(KamelConfig.Default)
            httpFetcher(ktorService().client.engine) {
                httpCache(DefaultHttpCacheSize)
            }
        }
        CompositionLocalProvider(LocalKamelConfig provides config) {
            KamelImage(
                modifier = Modifier.then(modifier),
                resource = asyncPainterResource(Url(url)),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}

actual fun libsImage(): ILibsImage = LibsImageImpl()