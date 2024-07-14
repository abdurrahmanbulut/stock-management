package com.abdurrahmanbulut.justlearn.di

import com.abdurrahmanbulut.justlearn.network.repository.SplashRepository
import org.koin.dsl.module

val repositoryModule =
    module {
        single { SplashRepository(get()) }
    }
