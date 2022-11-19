package com.example.poc.core.data.preferences

import kotlinx.coroutines.flow.Flow

interface PreferencesDataSource {

    fun observeTheme(): Flow<Theme>
    suspend fun setTheme(theme: Theme)

    fun observeIsNotificationEnabled(): Flow<Boolean>
    suspend fun setIsNotificationEnabled(isNotificationEnabled: Boolean)

}