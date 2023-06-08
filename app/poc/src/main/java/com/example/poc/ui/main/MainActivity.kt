package com.example.poc.ui.main

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.window.SplashScreenView
import androidx.annotation.IdRes
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.contains
import androidx.navigation.dynamicfeatures.fragment.DynamicNavHostFragment
import androidx.navigation.fragment.NavHostFragment
import com.example.poc.R
import com.example.poc.core.ui.event.EventViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.datetime.Clock
import kotlinx.datetime.toKotlinInstant
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.time.toKotlinDuration

/**
 *
 */
// It concerns to the main activity navigation actions between features, but not the navitaions
// internal to the features.
// The classes in the :app module knows about all features, but not it details while the classes
// in the feature modules, knows about it details, but not about the application or other features.
class MainActivity : AppCompatActivity(R.layout.main_activity) {

    private val viewModel: MainViewModel by viewModel()

    private val eventViewModel: EventViewModel by viewModel()

    private val navController by lazy {
        supportFragmentManager
            .findFragmentById(R.id.mainNavHostFragment)
            .let { it as DynamicNavHostFragment }
            .navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initSplashScreen()

        initEvents()

        initNavigation()
    }

    private fun initSplashScreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {

            // Set up an OnPreDrawListener to the root view.
            val content: View = findViewById(android.R.id.content)
            content.viewTreeObserver.addOnPreDrawListener(
                object : ViewTreeObserver.OnPreDrawListener {
                    override fun onPreDraw(): Boolean {
                        // Check if the initial data is ready.
                        return if (viewModel.isFastInitReady) {
                            // The content is ready; start drawing.
                            content.viewTreeObserver.removeOnPreDrawListener(this)
                            true
                        } else {
                            // The content is not ready; suspend.
                            false
                        }
                    }
                }
            )

            // Add a callback that's called when the splash screen is animating to
            // the app content.
            splashScreen.setOnExitAnimationListener { splashScreenView ->

                // Default implementation fades in, so we just remove the splash
                // This will remove immediately
                splashScreenView.remove()

//                // Create your custom animation.
//                val slideUp = ObjectAnimator.ofFloat(
//                    splashScreenView,
//                    View.TRANSLATION_Y,
//                    0f,
//                    -splashScreenView.height.toFloat()
//                )
//                slideUp.interpolator = AnticipateInterpolator()
//                slideUp.duration = 200L
//                slideUp.startDelay = splashScreenView.remainingAnimationDurationInMillis()
//
//                // Call SplashScreenView.remove at the end of your custom animation.
//                slideUp.doOnEnd { splashScreenView.remove() }
//
//                // Run your animation.
//                slideUp.start()
            }
        }
    }

    private fun waitForViewModelReady(){
        // Set up an OnPreDrawListener to the root view.
        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    // Check if the initial data is ready.
                    return if (viewModel.isFastInitReady) {
                        // The content is ready; start drawing.
                        content.viewTreeObserver.removeOnPreDrawListener(this)
                        true
                    } else {
                        // The content is not ready; suspend.
                        false
                    }
                }
            }
        )
    }

    private fun initEvents() {
        // Send events from shared view model to private view model channel.
        // We do this to keep the public delegates functions not accessible to the fragments.
        eventViewModel.events
            .onEach { viewModel.onEvent(it) }
            .flowWithLifecycle(lifecycle)
            .launchIn(lifecycleScope)
    }

    private fun initNavigation() {
        // Observe the navigation actions and navigate to a destination
        viewModel.destinations
            .onEach { destination ->
                when (destination.resId) {
                    // TODO Ideally should be navController.navigationUp()
                    MainViewModel.Destination.DESTINATION_UP.resId -> {
                        onBackPressed()
                    }
                    MainViewModel.Destination.POP_TO_START.resId -> {
                        navController.let {
                            it.popBackStack(
                                destinationId = it.graph.startDestinationId,
                                inclusive = true
                            )
                        }
                    }
                    else -> {
                        findNavController(destination.resId).let {
                            if (it.currentBackStackEntry?.destination?.id != destination.resId) {
                                it.navigate(
                                    resId = destination.resId,
                                    args = destination.args,
                                    navOptions = null,
                                    navigatorExtras = null
                                )
                            }
                        }
                    }
                }
            }
            .flowWithLifecycle(lifecycle)
            .launchIn(lifecycleScope)
    }

    @RequiresApi(Build.VERSION_CODES.S)
    private fun SplashScreenView.remainingAnimationDurationInMillis(): Long {
        // Get the duration of the animated vector drawable.
        val animationDuration = this.iconAnimationDuration?.toKotlinDuration()
        // Get the start time of the animation.
        val animationStart = this.iconAnimationStart?.toKotlinInstant()
        // Calculate the remaining duration of the animation.
        return if (animationDuration != null && animationStart != null) {
            (animationDuration - (animationStart - Clock.System.now()))
                .inWholeMinutes
                .coerceAtLeast(0L)
        } else 0L
    }

    /**
     * Find NavController for destination. If destination does not exist in the
     * NavController of this activity, tries to find on the fragments.
     */
    private fun findNavController(@IdRes destinationId: Int): NavController {
        // Throws if doesn't find it.
        return if (this.navController.graph.contains(destinationId)) this.navController
        else supportFragmentManager.fragments
            .find { it is DynamicNavHostFragment }!!
            .childFragmentManager.fragments
            .first()
            .childFragmentManager.fragments
            .find { it is DynamicNavHostFragment }
            .let { it as NavHostFragment }
            .navController
    }
}