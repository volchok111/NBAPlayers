package com.volchok.nbaplayers.library.api.domain

import com.volchok.nbaplayers.library.api.model.PlayerModel
import com.volchok.nbaplayers.library.data.model.Data
import com.volchok.nbaplayers.library.use_case.SuspendUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ObserveCharactersUseCase(
    private val repository: RemoteRepository,
) : SuspendUseCase<Unit, Flow<Data<List<PlayerModel>>>> {
    override suspend fun invoke(input: Unit): Flow<Data<List<PlayerModel>>>  = flow {
        emit(repository.getCharacters())
    }
}