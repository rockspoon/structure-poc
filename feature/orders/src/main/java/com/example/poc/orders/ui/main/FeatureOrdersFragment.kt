package com.example.poc.orders.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import com.example.poc.core.ui.event.EventViewModel
import org.koin.androidx.viewmodel.ext.android.activityViewModel


/**
 * This class is a proof-of-concept of a Fragment that uses Compose and paging library
 * for compose to fetch items filtered by a user query.
 *
 * The page consist of a list and a search text field to look up, as well as a detail page.
 *
 * The product list screen also has an action button to navigate to the settings feature.
 */
class FeatureOrdersFragment : Fragment() {

    private val eventViewModel: EventViewModel by activityViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                FeatureOrdersNavHost(eventViewModel)
            }
        }
    }
}



