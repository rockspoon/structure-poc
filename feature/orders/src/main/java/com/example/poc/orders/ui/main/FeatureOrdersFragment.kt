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



