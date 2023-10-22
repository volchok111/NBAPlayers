package com.volchok.nbaplayers.app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.volchok.nbaplayers.library.networking.system.NetworkDelegate
import com.volchok.nbaplayers.ui.theme.NBAPlayersTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val networkDelegate by inject<NetworkDelegate>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkDelegate.onCreate()

        setContent {
            NBAPlayersTheme {
                MainScreen()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        networkDelegate.onDestroy()
    }
}