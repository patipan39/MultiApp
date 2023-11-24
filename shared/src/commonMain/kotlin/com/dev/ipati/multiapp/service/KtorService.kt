package com.dev.ipati.multiapp.service

import io.ktor.client.HttpClient

interface IKtorService {
    val client: HttpClient
}

expect fun ktorService(): IKtorService