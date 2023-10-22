package com.volchok.nbaplayers.library.networking.domain

import com.volchok.nbaplayers.library.networking.model.NetworkConnection
import kotlinx.coroutines.flow.Flow

internal interface NetworkController {
    fun observeNetworkChange(): Flow<NetworkConnection>
}