package com.example.poc.auth.ui.main

import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.poc.auth.R
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class AuthFragmentTest {

    /**
     *
     */
    @Test
    fun whenUserInputsSevenDigitPassword_passwordInputLayout_shouldDisplayError() {

        // The "fragmentArgs" argument is optional.
        val fragmentArgs = bundleOf("selectedListItem" to 0)
        launchFragmentInContainer<AuthFragment>(
            fragmentArgs = fragmentArgs,
            themeResId = com.google.android.material.R.style.Theme_Material3_DayNight
        ).use {

            // Type a short (invalid) password
            val shortPassword = "1234567"
            onView(withId(R.id.passwordEditText)).perform(clearText(), typeText(shortPassword))

            // Close the keyboard and click the auth button. It's important
            // to close the keyboard because the button is behind it. Bad UX, I know, it's not
            // the focus in this PoC.
            onView(withId(R.id.passwordEditText)).perform(closeSoftKeyboard())
            onView(withId(R.id.authButton)).perform(click())

            // The input layout should show an error
            val context = InstrumentationRegistry.getInstrumentation().targetContext
            val expectedErrorText = context.getString(R.string.error_authentication_password_short)
            onView(withId(R.id.passwordInputLayout))
                .check(matches(hasTextInputLayoutError(expectedErrorText)))
        }
    }

    private fun hasTextInputLayoutError(expectedErrorText: String) =
        object : TypeSafeMatcher<View>() {

            override fun describeTo(description: Description?) {}

            override fun matchesSafely(item: View?): Boolean {
                if (item !is TextInputLayout) return false
                val error = item.error ?: return false
                val hint = error.toString()
                return expectedErrorText == hint
            }
        }
}