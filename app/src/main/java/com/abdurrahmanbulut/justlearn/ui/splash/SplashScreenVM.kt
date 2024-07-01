package com.abdurrahmanbulut.justlearn.ui.splash

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdurrahmanbulut.justlearn.network.repository.SplashRepository
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class SplashViewModel(private val repository: SplashRepository) : ViewModel(), KoinComponent {

    var test by mutableStateOf("")

    init {
        testService()
    }

    private fun testService(){
        viewModelScope.launch {
           val resp = repository.testService()
            test = resp.fact
        }
    }
}