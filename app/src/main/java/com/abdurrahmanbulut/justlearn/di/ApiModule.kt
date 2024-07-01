package com.abdurrahmanbulut.justlearn.di

import com.abdurrahmanbulut.justlearn.network.api.SplashApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://catfact.ninja/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SplashApi::class.java)
    }
}