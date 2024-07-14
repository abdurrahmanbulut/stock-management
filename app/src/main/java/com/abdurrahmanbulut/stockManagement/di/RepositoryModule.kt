package com.abdurrahmanbulut.stockManagement.di

import com.abdurrahmanbulut.stockManagement.network.repository.SplashRepository
import com.abdurrahmanbulut.stockManagement.network.repository.StockRepository
import org.koin.dsl.module

val repositoryModule =
    module {
        single { SplashRepository(get()) }
        single { StockRepository(get()) }
    }
