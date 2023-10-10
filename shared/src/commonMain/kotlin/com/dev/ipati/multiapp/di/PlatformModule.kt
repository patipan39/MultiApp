package com.dev.ipati.multiapp.di

import org.koin.core.module.Module

expect object PlatformModule {
    fun initialModule(): Module
}