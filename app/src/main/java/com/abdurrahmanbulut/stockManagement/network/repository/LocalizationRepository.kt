package com.abdurrahmanbulut.stockManagement.network.repository

import com.abdurrahmanbulut.stockManagement.constants.LocalizationKeys
import com.abdurrahmanbulut.stockManagement.network.api.LocalizationApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalizationRepository(private val api: LocalizationApi) {
    suspend fun fetchLocalizationStrings(lang: String): List<LocalizationKeys> {
        return withContext(Dispatchers.IO) {
            api.getLocalizationStrings(lang)
        }
    }
}
