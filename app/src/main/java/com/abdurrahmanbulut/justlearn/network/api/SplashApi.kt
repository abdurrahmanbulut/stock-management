package com.abdurrahmanbulut.justlearn.network.api

import com.abdurrahmanbulut.justlearn.model.Breeds
import com.abdurrahmanbulut.justlearn.model.CatFact
import retrofit2.http.GET

interface SplashApi {
    @GET("fact")
    suspend fun getFacts(): CatFact

    @GET("breeds")
    suspend fun getBreeds(): Breeds
}