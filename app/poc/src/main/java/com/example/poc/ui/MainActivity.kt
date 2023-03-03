package com.example.poc.ui

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.dynamicfeatures.fragment.DynamicNavHostFragment
import com.example.poc.R
import com.example.poc.core.ui.event.EventViewModel
import com.example.poc.core.ui.event.MainEvent
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 *
 */
// It concerns to the main activity navigation actions between features, but not the navitaions
// internal to the features.
// The classes in the :app module knows about all features, but not it details while the classes
// in the feature modules, knows about it details, but not about the application or other features.
class MainActivity : AppCompatActivity(R.layout.main_activity) {

    private val mainViewModel: MainViewModel by viewModel()

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

    override fun onStart() {
        super.onStart()
        eventViewModel.onEvent(MainEvent.OnMainStarted)
    }

    private fun initSplashScreen(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            splashScreen.setOnExitAnimationListener {

            }
        }
    }

    private fun initEvents(){
        // Send events from shared view model to private view model channel.
        // We do this to keep the public delegates functions not accessible to the fragments.
        eventViewModel.events
            .onEach { mainViewModel.onEvent(it) }
            .flowWithLifecycle(lifecycle)
            .launchIn(lifecycleScope)
    }

    private fun initNavigation() {
        // Observe the navigation actions and navigate to a destination
        // TODO test if i can navigate the inner navigation with this navigation or use included
        //      to unify the navigation graphs main and inner
        mainViewModel.destinations
            .onEach { destination ->
                navController.navigate(
                    resId = destination.resId,
                    args = destination.args,
                    navOptions = destination.navOptions,
                    navigatorExtras = destination.navigatorExtras
                )
            }
            .flowWithLifecycle(lifecycle)
            .launchIn(lifecycleScope)
    }
}