package com.volchok.nbaplayers.app.model

enum class Route {
    Splash,
    Home,
    Details;

    operator fun invoke() = name.lowercase()

    companion object {
        val Initial = Splash
    }
}