package com.rockspoon.test.data.preferences

import com.rockspoon.merchant.core.data.preferences.Preferences
import com.rockspoon.merchant.core.data.preferences.PreferencesDataStoreDataSource
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * A simple implementation of PreferenceDataSource that uses MutableStateFlow
 * to fake the PreferenceDataStore.
 */
class TestPreferencesDataStoreDataSource(
    defaultZoom: Boolean = true,
    displayCourseSelection: Boolean = true,
    fontScale: Float = 1.0f,
    brightness: Int = 204,
    theme: Preferences.Theme = Preferences.Theme.SYSTEM,
    isSoundEnabled: Boolean = true,
    isVibrationEnabled: Boolean = true
) : PreferencesDataStoreDataSource {

    override val displayCourseSelection: MutableStateFlow<Boolean> =
        MutableStateFlow(displayCourseSelection)

    override suspend fun setDisplayCourseSelection(enabled: Boolean) {
        this.displayCourseSelection.value = enabled
    }

    override val defaultZoom: MutableStateFlow<Boolean> = MutableStateFlow(defaultZoom)

    override suspend fun setDefaultZoom(defaultZoom: Boolean) {
        this.defaultZoom.value = defaultZoom
    }

    override val fontScale: MutableStateFlow<Float> = MutableStateFlow(fontScale)

    override suspend fun setFontScale(fontScale: Float) {
        this.fontScale.value = fontScale
    }

    override val brightness: MutableStateFlow<Int> = MutableStateFlow(brightness)

    override suspend fun setBrightness(brightness: Int) {
        this.brightness.value = brightness
    }

    override val theme: MutableStateFlow<Preferences.Theme> = MutableStateFlow(theme)

    override suspend fun setTheme(theme: Preferences.Theme) {
        this.theme.value = theme
    }

    override val isSoundEnabled: MutableStateFlow<Boolean> = MutableStateFlow(isSoundEnabled)

    override suspend fun setSoundEnabled(isSoundEnabled: Boolean) {
        this.isSoundEnabled.value = isSoundEnabled
    }

    override val isVibrationEnabled: MutableStateFlow<Boolean> =
        MutableStateFlow(isVibrationEnabled)

    override suspend fun setVibrationEnabled(isVibrationEnabled: Boolean) {
        this.isVibrationEnabled.value = isVibrationEnabled
    }
}