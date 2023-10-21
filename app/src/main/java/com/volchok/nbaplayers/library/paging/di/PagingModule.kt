package com.volchok.nbaplayers.library.paging.di

import com.volchok.nbaplayers.library.paging.data.PlayerRepositoryImpl
import com.volchok.nbaplayers.library.paging.domain.PlayerRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val pagingModule = module {
    factoryOf(::PlayerRepositoryImpl) bind PlayerRepository::class
}