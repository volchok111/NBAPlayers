package com.volchok.nbaplayers.app.model

enum class Route {
    Details,
    Home,
    Splash,
    Team;

    operator fun invoke() = name.lowercase()

    companion object {
        val Initial = Splash
    }
}