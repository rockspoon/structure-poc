package com.example.poc.core.data.preferences

import android.content.Context
import android.os.Build
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.poc.core.data.preferences.PreferencesDataSourceImpl.PreferencesKeys.NOTIFICATION
import com.example.poc.core.data.preferences.PreferencesDataSourceImpl.PreferencesKeys.THEME
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Class to set and retrieve the application preferences values using
 * a DataStore<Preference>.
 */
class PreferencesDataSourceImpl(
    private val dataStore: DataStore<Preferences>
) : PreferencesDataSource {

    override fun observeTheme(): Flow<Theme> = dataStore.data.map { preferences ->
        preferences[THEME]?.let { Theme.valueOf(it) }
            ?: when {
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q -> Theme.SYSTEM
                else -> Theme.BATTERY_SAVER
            }
    }

    override suspend fun setTheme(theme: Theme) {
        dataStore.edit { preferences ->
            preferences[THEME] = theme.name
        }
    }

    override fun observeIsNotificationEnabled() : Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[NOTIFICATION] ?: false
    }

    override suspend fun setIsNotificationEnabled(isNotificationEnabled: Boolean) {
        dataStore.edit { preferences ->
            preferences[NOTIFICATION] = isNotificationEnabled
        }
    }

    object PreferencesKeys {
        val THEME = stringPreferencesKey("preference_theme")
        val NOTIFICATION = booleanPreferencesKey("preference_notification")
    }

    companion object {

        private const val PREFS_NAME = "main"

        /**
         * Extension to retrieve an instance of PreferencesDataStore.
         */
        val Context.preferencesDataStore by preferencesDataStore(
            name = PREFS_NAME,
            produceMigrations = { context ->
                listOf(
                    SharedPreferencesMigration(context, PREFS_NAME)
                )
            }
        )
    }
}



