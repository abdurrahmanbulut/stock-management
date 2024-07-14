package com.abdurrahmanbulut.stockManagement.ui.splash

import androidx.lifecycle.ViewModel
import com.abdurrahmanbulut.stockManagement.network.repository.SplashRepository
import org.koin.core.component.KoinComponent

class SplashViewModel(private val repository: SplashRepository) : ViewModel(), KoinComponent
