package com.abdurrahmanbulut.justlearn.network.repository

import com.abdurrahmanbulut.justlearn.constants.LocalizationKeys
import com.abdurrahmanbulut.justlearn.network.api.LocalizationApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalizationRepository(private val api: LocalizationApi) {
    suspend fun fetchLocalizationStrings(lang: String): List<LocalizationKeys> {
        return withContext(Dispatchers.IO) {
            api.getLocalizationStrings(lang)
        }
    }
}
