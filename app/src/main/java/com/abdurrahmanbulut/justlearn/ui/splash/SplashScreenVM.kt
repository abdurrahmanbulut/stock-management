package com.abdurrahmanbulut.justlearn.ui.splash

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.abdurrahmanbulut.justlearn.network.repository.SplashRepository
import org.koin.core.component.KoinComponent

class SplashViewModel(private val repository: SplashRepository) : ViewModel(), KoinComponent
