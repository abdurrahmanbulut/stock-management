package com.abdurrahmanbulut.stockManagement

import android.app.Application
import com.abdurrahmanbulut.stockManagement.di.apiModule
import com.abdurrahmanbulut.stockManagement.di.repositoryModule
import com.abdurrahmanbulut.stockManagement.di.viewmodelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            val modules = listOf(repositoryModule, viewmodelModule, apiModule)
            androidLogger()
            androidContext(this@Application)
            koin.loadModules(modules)
        }
    }
}
