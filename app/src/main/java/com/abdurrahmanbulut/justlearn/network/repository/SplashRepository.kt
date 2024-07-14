package com.abdurrahmanbulut.justlearn.network.repository

import androidx.compose.runtime.MutableState
import com.abdurrahmanbulut.justlearn.model.Breeds
import com.abdurrahmanbulut.justlearn.model.CatFact
import com.abdurrahmanbulut.justlearn.network.api.SplashApi
import com.abdurrahmanbulut.sherlock.network.Service.call
import com.abdurrahmanbulut.sherlock.network.ServiceResult
import kotlinx.coroutines.CoroutineScope

class SplashRepository(private val api: SplashApi) {
    fun getFacts(
        coroutineScope: CoroutineScope,
        state: MutableState<ServiceResult<CatFact>>,
    ) {
        coroutineScope.call(state) {
            api.getFacts()
        }
    }

    fun getBreeds(
        coroutineScope: CoroutineScope,
        state: MutableState<ServiceResult<Breeds>>,
    )  {
        coroutineScope.call(state) {
            api.getBreeds()
        }
    }
}
