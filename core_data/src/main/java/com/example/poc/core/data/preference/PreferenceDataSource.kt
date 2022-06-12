package com.example.poc.core.data.preference

import kotlinx.coroutines.flow.Flow

interface PreferenceDataSource {

    fun observeTheme(): Flow<Theme>
    suspend fun setTheme(theme: Theme)

    fun observeIsNotificationEnabled(): Flow<Boolean>
    suspend fun setIsNotificationEnabled(isNotificationEnabled: Boolean)

}