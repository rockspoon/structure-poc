package com.example.auth.ui.auth

import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.auth.R
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
        launchFragmentInContainer<AuthFragment>(fragmentArgs).use {

            // Type a short (invalid) password
            val shortPassword = "1234567"
            onView(withId(R.id.passwordEditText)).perform(clearText(), typeText(shortPassword))

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
                val error = item.hint ?: return false
                val hint = error.toString()
                return expectedErrorText == hint
            }
        }
}