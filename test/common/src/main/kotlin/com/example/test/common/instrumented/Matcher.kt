package com.example.test.common.instrumented

import android.view.View
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

/**
 * Matcher used to check if TextInputLayout has the correct error message.
 */
fun hasTextInputLayoutError(error: String) = object : TypeSafeMatcher<View>() {

    override fun describeTo(description: Description?) {
        description?.appendText("has text input layout error with value: $error")
    }

    override fun matchesSafely(item: View?): Boolean {
        if (item !is TextInputLayout || item.error == null) return false
        val actualError = item.error.toString()
        return error == actualError
    }
}