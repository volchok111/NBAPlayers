package com.volchok.nbaplayers.library.api.model.details

data class Team(
    val abbreviation: String,
    val city: String,
    val conference: String,
    val division: String,
    val full_name: String,
    val id: Int,
    val name: String
)