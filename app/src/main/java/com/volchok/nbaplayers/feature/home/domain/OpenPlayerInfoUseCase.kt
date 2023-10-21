package com.volchok.nbaplayers.feature.home.domain

import com.volchok.nbaplayers.library.memory.domain.PlayerIdRepository
import com.volchok.nbaplayers.library.use_case.SynchronousUseCase

class OpenPlayerInfoUseCase(
    private val homeNavigationController: HomeNavigationController,
    private val playerIdRepository: PlayerIdRepository
) : SynchronousUseCase<Int, Unit>{
    override fun invoke(input: Int) {
        playerIdRepository.selectedPlayerId = input
        homeNavigationController.goToPlayerInfo()
    }
}