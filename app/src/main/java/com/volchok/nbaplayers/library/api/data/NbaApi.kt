package com.volchok.nbaplayers.library.api.data

import com.volchok.nbaplayers.library.api.model.PlayerEntity
import retrofit2.http.GET

interface NbaApi {

    @GET("players")
    suspend fun getPlayers(): PlayerEntity
}