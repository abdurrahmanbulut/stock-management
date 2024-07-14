package com.abdurrahmanbulut.stockManagement.network.api

import com.abdurrahmanbulut.stockManagement.constants.LocalizationKeys
import retrofit2.http.GET
import retrofit2.http.Query

interface LocalizationApi {
    @GET("localization")
    suspend fun getLocalizationStrings(
        @Query("lang") lang: String,
    ): List<LocalizationKeys>
}
