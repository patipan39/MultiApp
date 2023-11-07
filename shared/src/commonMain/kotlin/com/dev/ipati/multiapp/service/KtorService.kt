package com.dev.ipati.multiapp.service

import io.ktor.client.HttpClient

expect object KtorService {

    fun client(): HttpClient
}