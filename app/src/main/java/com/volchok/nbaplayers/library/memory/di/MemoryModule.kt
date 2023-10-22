package com.volchok.nbaplayers.library.memory.di

import com.volchok.nbaplayers.library.memory.data.MemoryPlayerDetailsRepository
import com.volchok.nbaplayers.library.memory.data.MemoryPlayerIdRepository
import com.volchok.nbaplayers.library.memory.data.MemoryTeamIdRepository
import com.volchok.nbaplayers.library.memory.data.MemoryTeamRepository
import com.volchok.nbaplayers.library.memory.domain.FetchPlayerDetailsUseCase
import com.volchok.nbaplayers.library.memory.domain.FetchTeamUseCase
import com.volchok.nbaplayers.library.memory.domain.GetSelectedPlayerIdUseCase
import com.volchok.nbaplayers.library.memory.domain.GetSelectedTeamIdUseCase
import com.volchok.nbaplayers.library.memory.domain.LocalPlayerRepository
import com.volchok.nbaplayers.library.memory.domain.LocalTeamRepository
import com.volchok.nbaplayers.library.memory.domain.ObservePlayerDetailsUseCase
import com.volchok.nbaplayers.library.memory.domain.ObserveTeamUseCase
import com.volchok.nbaplayers.library.memory.domain.PlayerIdRepository
import com.volchok.nbaplayers.library.memory.domain.TeamIdRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val memoryModule = module {
    factoryOf(::GetSelectedPlayerIdUseCase)
    factoryOf(::FetchPlayerDetailsUseCase)
    factoryOf(::ObservePlayerDetailsUseCase)

    singleOf(::MemoryPlayerDetailsRepository) bind LocalPlayerRepository::class
    singleOf(::MemoryPlayerIdRepository) bind PlayerIdRepository::class

    factoryOf(::GetSelectedTeamIdUseCase)
    factoryOf(::FetchTeamUseCase)
    factoryOf(::ObserveTeamUseCase)

    singleOf(::MemoryTeamRepository) bind LocalTeamRepository::class
    singleOf(::MemoryTeamIdRepository) bind TeamIdRepository::class
}