package com.volchok.nbaplayers.feature.details.domain

import com.volchok.nbaplayers.library.use_case.SynchronousUseCase

class GoBackUseCase(
    private val detailsNavigationController: DetailsNavigationController
) : SynchronousUseCase<Unit, Unit>{
    override fun invoke(input: Unit) {
       detailsNavigationController.goBack()
    }
}