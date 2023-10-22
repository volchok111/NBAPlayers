package com.volchok.nbaplayers.feature.details.domain

import com.volchok.nbaplayers.library.memory.domain.TeamIdRepository
import com.volchok.nbaplayers.library.use_case.SynchronousUseCase

class OpenTeamInfoUseCase(
    private val detailsNavigationController: DetailsNavigationController,
    private val teamIdRepository: TeamIdRepository
) : SynchronousUseCase<Int, Unit> {
    override fun invoke(input: Int) {
        teamIdRepository.selectedTeamId = input
        detailsNavigationController.goToTeamInfo()
    }
}