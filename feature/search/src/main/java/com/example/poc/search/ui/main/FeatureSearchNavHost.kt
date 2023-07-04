package com.example.poc.search.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.poc.core.ui.event.EventViewModel
import com.example.poc.core.ui.event.FeatureSearchEvent
import com.example.poc.search.ui.detail.ProductScreen
import com.example.poc.search.ui.list.ProductListScreen

// Composable that builds the nav graph internal of the feature. Navigation between features is
// handled by the MainActivity and dispatched with EventViewModel.
@Composable
internal fun FeatureSearchNavHost(
    eventViewModel: EventViewModel
) {
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