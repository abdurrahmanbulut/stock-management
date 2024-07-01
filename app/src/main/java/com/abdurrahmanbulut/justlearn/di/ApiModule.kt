package com.abdurrahmanbulut.justlearn.di

import com.abdurrahmanbulut.justlearn.network.api.SplashApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://catfact.ninja/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun splashApi(retrofit: Retrofit): SplashApi {
    return retrofit.create(SplashApi::class.java)
}

val apiModule = module {
    single { provideLoggingInterceptor() }
    single { provideOkHttpClient(get()) }
    single { provideRetrofit(get()) }
    single { splashApi(get()) }
}

fun provideLoggingInterceptor(): CustomHttpLoggingInterceptor {
    return CustomHttpLoggingInterceptor()
}

fun provideOkHttpClient(loggingInterceptor: CustomHttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
}
