package com.volchok.nbaplayers.feature.details.domain

import com.volchok.nbaplayers.library.memory.domain.TeamIdRepository
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import io.mockk.verify
import org.junit.Test

class OpenTeamInfoUseCaseTest {
    private val detailsNavigationController = mockk<DetailsNavigationController>()
    private val teamIdRepository = mockk<TeamIdRepository>()
    private val teamId = 1


    @Test
    fun `should open team info screen`() {
        every { detailsNavigationController.goToTeamInfo() } just runs
        every { teamIdRepository.selectedTeamId = any() } just runs

        val openTeamInfoUseCase = OpenTeamInfoUseCase(detailsNavigationController, teamIdRepository)
        openTeamInfoUseCase.invoke(teamId)

        verify { detailsNavigationController.goToTeamInfo() }
        verify { teamIdRepository.selectedTeamId = teamId }
    }
}