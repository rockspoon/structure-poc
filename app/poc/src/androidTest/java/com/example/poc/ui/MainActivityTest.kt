package com.example.poc.ui

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.poc.auth.domain.SignUpWithPasswordUseCase
import com.example.poc.core.data.preferences.PreferencesDataSource
import com.example.poc.core.data.preferences.Theme
import com.example.poc.core.data.user.*
import com.example.poc.ui.main.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.containsString
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
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    // runTest() is equivalent to TestScope().runTest(). If necessary, we can create a TestScope
    // customised and run instead ourCustomizedCoroutineScope.runTest() instead.
    @Test
    fun case_changeThemeToDark() = runTest {

        val testModule = module {

            // Fake data sources
            singleOf(MainActivityTest::FakeUserDatabaseDataSource) { bind<UserDatabaseDataSource>() }
            singleOf(MainActivityTest::EightDigitPasswordUserRemoteDataSource) { bind<UserRemoteDataSource>() }
            singleOf(MainActivityTest::FakePreferencesDataSource) { bind<PreferencesDataSource>() }

            single {
                SignUpWithPasswordUseCase(
                    coroutineDispatcher = get(),
                    userRepository = UserRepositoryImpl(
                        userDatabaseDataSource = get(),
                        userRemoteDataSource = get()
                    )
                )
            }
        }

        // TODO It's not working as expected. I expected this to run all coroutines
        // in order so the test checks only be called after the coroutines finishes.
        Dispatchers.setMain(StandardTestDispatcher())

        loadKoinModules(testModule)

        val context = InstrumentationRegistry.getInstrumentation().targetContext
        launchActivity<MainActivity>().use { scenario ->

            // Type the credentials
            val email = "jon.snow@example.com"
            onView(
                withId(com.example.poc.auth.R.id.emailEditText)
            ).perform(
                clearText(),
                typeText(email)
            )
            val password = "12345678"
            onView(
                withId(com.example.poc.auth.R.id.passwordEditText)
            ).perform(
                clearText(),
                typeText(password)
            )

            // Close the keyboard and click the auth button. It's important
            // to close the keyboard because the button is behind it.
            onView(
                withId(com.example.poc.auth.R.id.passwordEditText)
            ).perform(
                closeSoftKeyboard()
            )
            onView(
                withId(com.example.poc.auth.R.id.authButton)
            ).perform(
                click()
            )

            // Wait for coroutines to finish
            advanceUntilIdle()

            // We should go to the home page and see a greetings
            val helloString =
                context.getString(com.example.poc.home.R.string.greetings_template)
                    .substring(0..4)
            onView(withText(containsString(helloString))).check(matches(isDisplayed()))

            // Go to settings by clicking in the bottom navigation
            onView(
                allOf(
                    withText(context.getString(com.example.poc.R.string.title_feature_settings)),
                    isDescendantOfA(withId(com.example.poc.R.id.bottom_navigation_view)),
                    isDisplayed()
                )
            ).perform(
                click()
            )

            // Make sure it was off when started
            onView(
                withId(com.example.poc.settings.R.id.themeSwitch)
            ).check(
                matches(isNotChecked())
            )

            // Click the switch button
            onView(
                withId(com.example.poc.settings.R.id.themeSwitch)
            ).perform(
                click()
            )

            // Check if it's on now.
            onView(
                withId(com.example.poc.settings.R.id.themeSwitch)
            ).check(
                matches(isChecked())
            )

            // The app preferences value for theme should be DARK now
            onView(
                withId(com.example.poc.settings.R.id.themeTextView)
            ).check(
                matches(withText(Theme.DARK.name))
            )
        }
    }

    // A simple implementation of PreferenceDataSource that uses MutableStateFlow
    // to mimic the data store behavior
    private class FakePreferencesDataSource : PreferencesDataSource {

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
            // Simulate a insert
            delay(3000)
            userTable[user.id ?: 1] = user
            return userTable[user.id ?: 1]!!
        }

    }

    private class EightDigitPasswordUserRemoteDataSource : UserRemoteDataSource {

        // Mock a server
        private val users = mutableMapOf<Long, User>()

        override suspend fun getUser(id: Long?): User {
            return users[id]!!
        }

        override suspend fun updateUser(user: User): User {
            TODO("Not yet implemented")
        }

        override suspend fun insertUser(user: User): User {
            if (user.id == null) throw UserRepository.UserIdNullException

            val password = user.password?.length ?: 0
            if (password < 8) throw UserRepository.UserPasswordShortException

            users[user.id!!] = user
            return user
        }

        override suspend fun listUsers(
            name: String,
            profileIds: List<Long>,
            pageSize: Int,
            next: String,
            previous: String
        ): List<User> {
            TODO("Not yet implemented")
        }
    }

}