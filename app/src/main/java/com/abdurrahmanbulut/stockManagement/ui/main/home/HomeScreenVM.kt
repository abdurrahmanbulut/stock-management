package com.abdurrahmanbulut.stockManagement.ui.main.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdurrahmanbulut.stockManagement.model.StockResponse
import com.abdurrahmanbulut.stockManagement.network.repository.StockRepository

class HomeScreenVM(private val stockRepository: StockRepository) : ViewModel() {
    val test = "Home Screen"

    val stock: MutableState<StockResponse?> = mutableStateOf(null)

    init {
        getStock()
    }

    private fun getStock() {
        stockRepository.getStockPrice(viewModelScope, "IBM")
            .success {
                println(it)
                println(it.globalQuote.symbol)
                println(it.globalQuote.price)
            }
            .failure {
                println(it)
            }
    }
}
