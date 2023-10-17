package com.volchok.nbaplayers.library.api.model

data class PlayerModel(
    val first_name: String,
    val id: Int,
    val last_name: String,
    val team: Team,
)