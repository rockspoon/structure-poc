package com.rockspoon.test.data.preferences

import com.rockspoon.merchant.core.data.preferences.Preferences
import com.rockspoon.merchant.core.data.preferences.PreferencesRemoteDataSource
import kotlinx.coroutines.delay

/**
 * A fake PreferencesRemoteDataSource that simulates a successful call that takes 200 ms.
 */
class TestPreferencesRemoteDataSource(
    var preferences: Preferences = Preferences(),
    private val networkCallDelayInMillis: Long = DEFAULT_NETWORK_CALL_DELAY
) : PreferencesRemoteDataSource {

    override suspend fun getPreferences(): Preferences {
        delay(networkCallDelayInMillis)
        return preferences
    }

    override suspend fun updatePreferences(preferences: Preferences): Preferences {
        delay(networkCallDelayInMillis)
        this.preferences = preferences
        return preferences
    }

    companion object {
        const val DEFAULT_NETWORK_CALL_DELAY = 200L
    }
}