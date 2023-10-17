package com.volchok.nbaplayers.library.api.di

import com.volchok.nbaplayers.library.api.data.NbaApi
import com.volchok.nbaplayers.library.api.data.RickMortyRepository
import com.volchok.nbaplayers.library.api.domain.ObserveCharactersUseCase
import com.volchok.nbaplayers.library.api.domain.RemoteRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val apiModule = module {
    factory {
        Retrofit.Builder()
            .baseUrl("https://www.balldontlie.io/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .followSslRedirects(false)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(40, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .addInterceptor(
                        HttpLoggingInterceptor()
                            .setLevel(HttpLoggingInterceptor.Level.BODY)
                    )
                    .build()
            )
            .build()
            .create(NbaApi::class.java)
    }

    factoryOf(::ObserveCharactersUseCase)
    factoryOf(::RickMortyRepository) bind RemoteRepository::class
}