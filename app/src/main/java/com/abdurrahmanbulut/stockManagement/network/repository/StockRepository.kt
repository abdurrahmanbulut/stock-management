package com.abdurrahmanbulut.stockManagement.network.repository

import androidx.compose.runtime.MutableState
import com.abdurrahmanbulut.sherlock.network.Service.call
import com.abdurrahmanbulut.sherlock.network.ServiceResult
import com.abdurrahmanbulut.stockManagement.model.StockResponse
import com.abdurrahmanbulut.stockManagement.network.api.StockApi
import kotlinx.coroutines.CoroutineScope

class StockRepository(private val api: StockApi) {
    fun getStockPrice(
        coroutineScope: CoroutineScope,
        symbol: String,
        state: MutableState<ServiceResult<StockResponse>>,
    ) {
        coroutineScope.call(state) {
            api.getStockPrice(
                function = "GLOBAL_QUOTE",
                symbol = symbol,
                apiKey = "GUUGH1WRKYZZD4GF",
            )
        }
    }
}
