package com.example.poc.settings.ui

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.poc.core.data.preferences.PreferencesDataSource
import com.example.poc.core.data.preferences.Theme
import com.example.poc.core.domain.coreDomainModule
import com.example.poc.settings.R
import com.example.poc.settings.featureSettingsModule
import com.google.android.material.switchmaterial.SwitchMaterial
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.startKoin
import org.koin.dsl.module

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class SettingsFragmentTest {

    /**
     *
     */
    @Test
    fun whenUserTurnOnNotificationToggleButton_preferencesDataSourceNotification_shouldBeTrue() {

        val testModule = module {

            single<CoroutineDispatcher>{
                Dispatchers.IO
            }

            // We fake a data source for our preferences.
            single<PreferencesDataSource> {
                FakePreferencesDataSource()
            }
        }

        startKoin {
            // Add featureSettingsModule but also coreDomainModule because the observe use cases
            // comes from it.
            modules(
                coreDomainModule(),
                featureSettingsModule(),
                testModule
            )
        }

        launchFragmentInContainer<SettingsFragment>(
            fragmentArgs = null,
            themeResId = com.google.android.material.R.style.Theme_Material3_Dark,
            initialState = Lifecycle.State.RESUMED
        ).use { scenario ->

            // Make sure it was off when started
            scenario.onFragment {
                val actualChecked =
                    it.requireView().findViewById<SwitchMaterial>(R.id.notificationSwitch).isChecked
                assertEquals(false, actualChecked)
            }

            // Click the switch button
            onView(withId(R.id.notificationSwitch))
                .perform(ViewActions.click())

            // The app preferences value for notifications should be true now
            scenario.onFragment {
                val actualChecked =
                    it.requireView().findViewById<SwitchMaterial>(R.id.notificationSwitch).isChecked
                assertEquals(true, actualChecked)
            }

            // Check if it's on now.
            onView(withId(R.id.notificationTextView))
                .check(ViewAssertions.matches(withText(true.toString())))

        }
    }

    // A simple implementation of PreferenceDataSource that uses MutableStateFlow
    // to mimic the data store behavior
    class FakePreferencesDataSource : PreferencesDataSource {

        private var theme: MutableStateFlow<Theme> = MutableStateFlow(Theme.SYSTEM)

        private var isNotificationEnabled = MutableStateFlow(false)

        override fun observeTheme(): Flow<Theme> = theme

        override suspend fun setTheme(theme: Theme) {
            this.theme.value = theme
        }

        override fun observeIsNotificationEnabled() = isNotificationEnabled

        override suspend fun setIsNotificationEnabled(isNotificationEnabled: Boolean) {
            this.isNotificationEnabled.value = isNotificationEnabled
        }

    }
}