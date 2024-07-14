package com.abdurrahmanbulut.stockManagement.ui.main.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdurrahmanbulut.sherlock.network.ServiceResult
import com.abdurrahmanbulut.stockManagement.model.CatFact
import com.abdurrahmanbulut.stockManagement.network.repository.SplashRepository

class HomeScreenVM(private val splashRepository: SplashRepository) : ViewModel() {
    val test = "Home Screen"

    val catFact: MutableState<ServiceResult<CatFact>> = mutableStateOf(ServiceResult.Loading)

    init {
        getFacts()
    }

    private fun getFacts() {
        splashRepository.getFacts(viewModelScope, catFact)
    }
}
