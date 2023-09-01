package com.dev.ipati.multiapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform