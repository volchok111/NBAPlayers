package com.volchok.nbaplayers.app.domain

import com.volchok.nbaplayers.library.use_case.SynchronousUseCase

class GoToHomeUseCase(
    private val mainNavigationController: MainNavigationController
) : SynchronousUseCase<Unit, Unit>{
    override fun invoke(input: Unit) {
        mainNavigationController.goHome()
    }
}