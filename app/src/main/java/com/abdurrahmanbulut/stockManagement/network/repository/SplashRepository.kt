package com.abdurrahmanbulut.stockManagement.network.repository

import com.abdurrahmanbulut.sherlock.network.Service.call
import com.abdurrahmanbulut.stockManagement.network.api.SplashApi
import kotlinx.coroutines.CoroutineScope

class SplashRepository(private val api: SplashApi) {
    fun getFacts(
        coroutineScope: CoroutineScope,
    ) {
        coroutineScope.call() {
            api.getFacts()
        }
    }

    fun getBreeds(
        coroutineScope: CoroutineScope
    ) {
        coroutineScope.call() {
            api.getBreeds()
        }
    }
}
