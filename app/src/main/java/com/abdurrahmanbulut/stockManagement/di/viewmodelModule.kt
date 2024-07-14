package com.abdurrahmanbulut.stockManagement.di

import com.abdurrahmanbulut.stockManagement.ui.InsetsViewModel
import com.abdurrahmanbulut.stockManagement.ui.main.MainScreenVM
import com.abdurrahmanbulut.stockManagement.ui.main.home.HomeScreenVM
import com.abdurrahmanbulut.stockManagement.ui.main.settings.SettingsScreenVM
import com.abdurrahmanbulut.stockManagement.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodelModule =
    module {
        viewModel { SplashViewModel(get()) }
        viewModel { HomeScreenVM(get()) }
        viewModel { InsetsViewModel() }
        viewModel { SettingsScreenVM() }
        viewModel { MainScreenVM() }
    }
