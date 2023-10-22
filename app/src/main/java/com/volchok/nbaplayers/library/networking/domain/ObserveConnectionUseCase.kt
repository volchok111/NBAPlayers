package com.volchok.nbaplayers.library.networking.domain

import com.volchok.nbaplayers.library.use_case.SynchronousUseCase
import com.volchok.nbaplayers.library.networking.model.NetworkConnection
import kotlinx.coroutines.flow.Flow

class ObserveConnectionUseCase internal constructor(
    private val networkController: NetworkController,
) : SynchronousUseCase<Unit, Flow<NetworkConnection>> {

    override fun invoke(input: Unit): Flow<NetworkConnection> =
        networkController.observeNetworkChange()
}