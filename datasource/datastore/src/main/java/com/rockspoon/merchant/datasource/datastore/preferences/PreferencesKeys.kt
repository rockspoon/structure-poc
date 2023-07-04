package com.rockspoon.merchant.datasource.datastore.preferences

import android.content.Context
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

object PreferencesKeys {

    val PREF_DISPLAY_COURSE_SELECTION = booleanPreferencesKey("pref_display_course_selection")
    val PREF_DEFAULT_ZOOM = booleanPreferencesKey("pref_default_zoom")
    val PREF_FONT_SCALE = floatPreferencesKey("pref_font_scale")
    val PREF_BRIGHTNESS = intPreferencesKey("pref_brightness")
    val PREF_OVERRIDE_SYSTEM_BRIGHTNESS = booleanPreferencesKey("pref_override_system_brightness")
    val PREF_THEME = stringPreferencesKey("pref_theme")
    val PREF_SOUND_ENABLED = booleanPreferencesKey("pref_sound_enabled")
    val PREF_VIBRATION_ENABLED = booleanPreferencesKey("pref_vibration_enabled")

    // NOTE: This constant value changed from the last, so sync values with server will be necessary
    // at first update
    private const val PREFERENCE_DATASTORE_NAME = "preference_datastore"

    /** Extension to retrieve an instance of PreferencesDataStore. */
    val Context.preferencesDataStore by preferencesDataStore(
        name = PREFERENCE_DATASTORE_NAME,
        produceMigrations = { context ->
            listOf(
                SharedPreferencesMigration(context, PREFERENCE_DATASTORE_NAME)
            )
        }
    )
}