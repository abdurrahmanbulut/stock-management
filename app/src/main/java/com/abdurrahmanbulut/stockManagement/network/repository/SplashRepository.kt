package com.abdurrahmanbulut.stockManagement.network.repository

import androidx.compose.runtime.MutableState
import com.abdurrahmanbulut.sherlock.network.Service.call
import com.abdurrahmanbulut.sherlock.network.ServiceResult
import com.abdurrahmanbulut.stockManagement.model.Breeds
import com.abdurrahmanbulut.stockManagement.model.CatFact
import com.abdurrahmanbulut.stockManagement.network.api.SplashApi
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
    ) {
        coroutineScope.call(state) {
            api.getBreeds()
        }
    }
}
