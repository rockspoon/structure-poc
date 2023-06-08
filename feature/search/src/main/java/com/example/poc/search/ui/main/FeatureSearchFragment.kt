package com.example.poc.search.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import com.example.poc.core.ui.event.EventViewModel
import com.example.poc.search.loadModule
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
                FeatureSearchNavHost(eventViewModel)
            }
        }
    }
}



