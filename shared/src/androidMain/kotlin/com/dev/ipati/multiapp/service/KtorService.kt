package com.dev.ipati.multiapp.service

import com.dev.ipati.multiapp.Variable
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class KtorServiceImpl : IKtorService {
    override val client: HttpClient
        get() = HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
            defaultRequest {
                url {
                    protocol = URLProtocol.HTTPS
                    host = Variable.baseUrl
                }
            }
        }
}

actual fun ktorService(): IKtorService = KtorServiceImpl()