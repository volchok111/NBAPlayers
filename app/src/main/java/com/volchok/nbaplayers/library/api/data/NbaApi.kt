package com.volchok.nbaplayers.library.api.data

import com.volchok.nbaplayers.library.api.model.PlayerEntity
import com.volchok.nbaplayers.library.api.model.details.PlayerDetailsEntity
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NbaApi {

    @GET("players")
    suspend fun getPlayers(@Query("page") page: Int): PlayerEntity

    @GET("players/{id}")
    suspend fun getPlayerDetails(@Path(value = "id") id: Int): PlayerDetailsEntity
}