package com.example.poc.orders.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.poc.core.ui.event.EventViewModel
import com.example.poc.core.ui.event.FeatureSearchEvent
import com.example.poc.orders.ui.list.OrdersScreen

// Composable that builds the nav graph internal of the feature. Navigation between features is
// handled by the MainActivity and dispatched with EventViewModel.
@Composable
internal fun FeatureOrdersNavHost(
    eventViewModel: EventViewModel
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "products") {
        composable(
            route = "products"
        ) {
            OrdersScreen(
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
        /* composable(
             route = "products/{productId}",
             arguments = listOf(
                 navArgument("productId") { type = NavType.LongType }
             )
         ) {
             ProductScreen(
                 onBackClick = { navController.navigateUp() }
             )
         }*/
    }
}