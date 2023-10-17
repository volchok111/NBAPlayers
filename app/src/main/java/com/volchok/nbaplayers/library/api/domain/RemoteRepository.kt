package com.volchok.nbaplayers.library.api.domain

import com.volchok.nbaplayers.library.api.model.PlayerModel
import com.volchok.nbaplayers.library.data.model.Data

interface RemoteRepository {
    suspend fun getCharacters(): Data<List<PlayerModel>>
}