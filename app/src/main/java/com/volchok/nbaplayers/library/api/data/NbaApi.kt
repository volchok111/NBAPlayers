package com.volchok.nbaplayers.library.api.data

import com.volchok.nbaplayers.library.api.model.PlayerModel
import retrofit2.http.GET

interface NbaApi {

    @GET("players")
    suspend fun getPlayers(): List<PlayerModel>
}