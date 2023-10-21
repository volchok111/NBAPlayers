package com.volchok.nbaplayers.library.api.di

import com.volchok.nbaplayers.library.api.data.NbaApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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

  //  factoryOf(::RemoteRepositoryImpl) bind RemoteRepository::class
}