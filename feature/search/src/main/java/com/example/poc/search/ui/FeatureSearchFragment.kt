package com.example.poc.search.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.poc.core.ui.event.EventViewModel
import com.example.poc.core.ui.event.FeatureSearchEvent
import com.example.poc.search.loadModule
import com.example.poc.search.ui.detail.ProductScreen
import com.example.poc.search.ui.list.ProductListScreen
import org.koin.androidx.viewmodel.ext.android.activityViewModel


/**
 * This class is a proof-of-concept of a Fragment that uses Compose and paging library
 * for compose to fetch items filtered by a user query.
 *
 * The page consist of a list and a search text field to look up, as well as a detail page.
 *
 * The product list screen also has an action button to navigate to the settings feature.
 */
class FeatureSearchFragment : Fragment() {

    private val eventViewModel: EventViewModel by activityViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        loadModule()

        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                FeatureSearchNavHost()
            }
        }
    }

    // Composable that builds the nav graph internal of the feature. Navigation between features is
    // handled by the MainActivity and dispatched with EventViewModel.
    @Composable
    internal fun FeatureSearchNavHost() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "products") {
            composable(
                route = "products"
            ) {
                ProductListScreen(
                    onItemClicked = {
                        // Internal navigation
                        navController.navigate("products/${it.id}")
                    },
                    onActionSettingsClicked = {
                        // Event that will lead to an external navigation
                        // The event could also lead to any other action that the MainActivity
                        // must handle, like showing a permission dialog.
                        eventViewModel.postEvent(FeatureSearchEvent.OnActionSettingsClicked)
                    }
                )
            }
            composable(
                route = "products/{productId}",
                arguments = listOf(
                    navArgument("productId") { type = NavType.LongType }
                )
            ) {
                ProductScreen(
                    onBackClick = { navController.navigateUp() }
                )
            }
        }
    }
}



