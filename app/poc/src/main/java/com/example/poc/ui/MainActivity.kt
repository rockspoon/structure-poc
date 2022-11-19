package com.example.poc.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.dynamicfeatures.fragment.DynamicNavHostFragment
import com.example.poc.R
import com.example.poc.databinding.MainActivityBinding
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
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Binding
        val binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Observe the navigation actions and navigate to a destination
        // TODO test if i can navigate the inner navigation with this navigation or use included
        //      to unify the navigation graphs main and inner
        val navController = supportFragmentManager
            .findFragmentById(R.id.mainNavHostFragment)
            .let { it as DynamicNavHostFragment }
            .navController
        mainViewModel.destinations.onEach { destination ->
            navController.navigate(
                resId = destination.resId,
                args = destination.args,
                navOptions = destination.navOptions,
                navigatorExtras = destination.navigatorExtras
            )
        }.launchIn(lifecycleScope)

        // Register an intention to show the main screen.
        // This can be fulfilled or not, now or later.
        mainViewModel.startMain()
    }
}