package com.volchok.nbaplayers.library.api.data

import com.volchok.nbaplayers.library.api.model.PlayerEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface NbaApi {

    @GET("players")
    suspend fun getPlayers(@Query("page") page: Int): PlayerEntity
}