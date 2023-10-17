package com.volchok.nbaplayers.app.model

enum class Route {
    Home,
    Details;

    operator fun invoke() = name.lowercase()

    companion object {
        val Initial = Home
    }
}