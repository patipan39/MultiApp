package com.dev.ipati.multiapp

import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.dev.ipati.multiapp.service.KtorService
import io.kamel.core.config.DefaultHttpCacheSize
import io.kamel.core.config.KamelConfig
import io.kamel.core.config.httpFetcher
import io.kamel.core.config.takeFrom
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import io.kamel.image.config.Default
import io.kamel.image.config.LocalKamelConfig
import io.ktor.http.Url

actual object LibsImage {
    @Composable
    actual fun KamelImage(modifier: Modifier, url: String) {
        val config = KamelConfig {
            takeFrom(KamelConfig.Default)
            httpFetcher(KtorService.client().engine) {
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