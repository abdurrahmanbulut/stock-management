package com.abdurrahmanbulut.justlearn.network.repository

import com.abdurrahmanbulut.justlearn.model.CatFact
import com.abdurrahmanbulut.justlearn.network.api.SplashApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SplashRepository(private val api: SplashApi) {

    suspend fun testService(): CatFact {
        return withContext(Dispatchers.IO) {
            api.testService()
        }
    }
}

