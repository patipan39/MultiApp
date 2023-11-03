package com.dev.ipati.multiapp.android

import android.app.Application
import com.dev.ipati.multiapp.di.PlatformModule
import com.dev.ipati.multiapp.di.commonModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(
                PlatformModule.initialModule() + commonModule
            )
        }
    }
}