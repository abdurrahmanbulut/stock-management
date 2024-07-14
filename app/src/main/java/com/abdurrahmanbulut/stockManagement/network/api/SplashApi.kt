package com.abdurrahmanbulut.stockManagement.network.api

import com.abdurrahmanbulut.stockManagement.model.Breeds
import com.abdurrahmanbulut.stockManagement.model.CatFact
import retrofit2.http.GET

interface SplashApi {
    @GET("fact")
    suspend fun getFacts(): CatFact

    @GET("breeds")
    suspend fun getBreeds(): Breeds
}
