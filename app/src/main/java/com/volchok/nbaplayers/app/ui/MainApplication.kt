package com.volchok.nbaplayers.app.ui

import android.app.Application
import com.volchok.nbaplayers.app.di.mainModule
import com.volchok.nbaplayers.feature.details.di.detailsModule
import com.volchok.nbaplayers.feature.home.di.homeModule
import com.volchok.nbaplayers.feature.team.di.teamModule
import com.volchok.nbaplayers.library.api.di.apiModule
import com.volchok.nbaplayers.library.memory.di.memoryModule
import com.volchok.nbaplayers.library.networking.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        startKoin {
            androidContext(applicationContext)
            modules(
                apiModule,
                detailsModule,
                homeModule,
                mainModule,
                memoryModule,
                teamModule,
                networkModule
            )
        }
        super.onCreate()
    }
}