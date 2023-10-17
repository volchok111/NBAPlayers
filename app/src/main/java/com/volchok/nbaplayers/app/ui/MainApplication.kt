package com.volchok.nbaplayers.app.ui

import android.app.Application
import com.volchok.nbaplayers.app.di.mainModule
import com.volchok.nbaplayers.feature.home.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        startKoin {
            androidContext(applicationContext)
            modules(
                mainModule,
                homeModule
            )
        }
        super.onCreate()
    }
}