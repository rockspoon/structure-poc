package com.example.poc.ui

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.poc.auth.domain.SignUpWithPasswordUseCase
import com.example.poc.core.data.preference.PreferenceDataSource
import com.example.poc.core.data.preference.Theme
import com.example.poc.core.data.user.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.containsString
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun case_changeThemeToDark() {

        val testModule = module {

            // TODO change all the dispatchers to coroutine TestDispatcher so we can
            // sync the interface actions and the data flow on the tests.
            single {
                Dispatchers.IO
            }

            // Fake data sources
            singleOf(::FakeUserDatabaseDataSource) { bind<UserDatabaseDataSource>() }
            singleOf(::FakeUserNetworkDataSource) { bind<UserNetworkDataSource>() }
            singleOf(::FakePreferenceDataSource) { bind<PreferenceDataSource>() }

            single {
                SignUpWithPasswordUseCase(
                    coroutineDispatcher = get(),
                    userRepository = UserRepositoryImpl(
                        userDatabaseDataSource = get(),
                        userNetworkDataSource = get()
                    )
                )
            }
        }

        loadKoinModules(testModule)

        val context = InstrumentationRegistry.getInstrumentation().targetContext
        launchActivity<MainActivity>().use { scenario ->

            // Type the credentials
            val email = "jon.snow@example.com"
            onView(withId(com.example.poc.auth.R.id.emailEditText)).perform(
                clearText(),
                typeText(email)
            )
            val password = "12345678"
            onView(withId(com.example.poc.auth.R.id.passwordEditText)).perform(
                clearText(),
                typeText(password)
            )

            // Close the keyboard and click the auth button. It's important
            // to close the keyboard because the button is behind it.
            onView(withId(com.example.poc.auth.R.id.passwordEditText))
                .perform(closeSoftKeyboard())
            onView(withId(com.example.poc.auth.R.id.authButton)).perform(click())

            // We should go to the home page and see a greetings
            val helloString =
                context.getString(com.example.home.R.string.greetings_template).substring(0..4)
            onView(withText(containsString(helloString))).check(matches(isDisplayed()))

            // Go to settings by clicking in the bottom navigation
            onView(
                allOf(
                    withText(context.getString(com.example.poc.R.string.title_feature_settings)),
                    isDescendantOfA(withId(com.example.poc.R.id.bottom_navigation_view)),
                    isDisplayed()
                )
            ).perform(click())

            // Make sure it was off when started
            onView(
                withId(com.example.settings.R.id.themeSwitch)
            ).check(
                matches(isNotChecked())
            )

            // Click the switch button
            onView(
                withId(com.example.settings.R.id.themeSwitch)
            ).perform(
                click()
            )

            // The app preferences value for notifications should be true now
            onView(
                withId(com.example.settings.R.id.themeSwitch)
            ).check(
                matches(isChecked())
            )

            // Check if it's on now.
            onView(
                withId(com.example.settings.R.id.themeTextView)
            ).check(
                matches(withText(Theme.DARK.name))
            )

        }
    }

    // A simple implementation of PreferenceDataSource that uses MutableStateFlow
    // to mimic the data store behavior
    private class FakePreferenceDataSource : PreferenceDataSource {

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

    private class FakeUserDatabaseDataSource : UserDatabaseDataSource {

        private val userTable = hashMapOf<Long, User>()

        override suspend fun getUser(id: Long): User? {
            return userTable[id]
        }

        override fun observeUser(id: Long): Flow<User?> = flow {
            val user = userTable[id]
            emit(user)
        }

        override suspend fun insertUser(user: User): User {
            // TODO make the tests working with Dispatchers.Main
            //delay(3000)
            userTable[user.id ?: 1] = user
            return userTable[user.id ?: 1]!!
        }

    }

    private class FakeUserNetworkDataSource : UserNetworkDataSource {

        // Mock a server
        private val users = mutableMapOf<Long, User>()

        override suspend fun getUser(id: Long): User? {
            return users[id]
        }

        override suspend fun insertUser(user: User): User {
            if (user.id == null) throw UserRepository.UserIdNullException

            val password = user.password?.length ?: 0
            if (password < 8) throw UserRepository.UserPasswordShortException

            users[user.id!!] = user
            return user
        }
    }
}