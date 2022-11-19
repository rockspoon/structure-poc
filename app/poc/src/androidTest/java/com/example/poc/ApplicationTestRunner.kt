package com.example.poc

import android.content.Context
import androidx.test.runner.AndroidJUnitRunner

/**
 * A runner for the test application.
 */
@Suppress("unused") // It's being used in the :app build.gradle
class ApplicationTestRunner : AndroidJUnitRunner() {

    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): android.app.Application {
        return super.newApplication(cl, ApplicationTest::class.java.name, context)
    }
}