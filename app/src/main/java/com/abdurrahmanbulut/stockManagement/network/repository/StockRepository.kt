package com.abdurrahmanbulut.stockManagement.network.repository

import com.abdurrahmanbulut.sherlock.network.CallHandler
import com.abdurrahmanbulut.sherlock.network.Service.call
import com.abdurrahmanbulut.stockManagement.model.StockResponse
import com.abdurrahmanbulut.stockManagement.network.api.StockApi
import kotlinx.coroutines.CoroutineScope

class StockRepository(private val api: StockApi) {
    fun getStockPrice(
        coroutineScope: CoroutineScope,
        symbol: String,
    ) : CallHandler<StockResponse> {
        return coroutineScope.call(
            repositoryCall = {
                api.getStockPrice(
                    function = "GLOBAL_QUOTE",
                    symbol = symbol,
                    apiKey = "GUUGH1WRKYZZD4GF",
                )
            }
        )
    }
}
