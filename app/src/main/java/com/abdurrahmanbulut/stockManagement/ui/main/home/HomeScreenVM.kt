package com.abdurrahmanbulut.stockManagement.ui.main.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdurrahmanbulut.sherlock.network.ServiceResult
import com.abdurrahmanbulut.stockManagement.model.StockResponse
import com.abdurrahmanbulut.stockManagement.network.repository.StockRepository

class HomeScreenVM(private val stockRepository: StockRepository) : ViewModel() {
    val test = "Home Screen"

    val stock: MutableState<ServiceResult<StockResponse>> = mutableStateOf(ServiceResult.Loading)

    init {
        getStock()
    }

    private fun getStock() {
        stockRepository.getStockPrice(viewModelScope, "IBM", stock)
    }
}
