package com.example.poc.search.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.poc.search.loadModule
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * This class is a proof-of-concept of a Fragment that uses Compose and paging library
 * for compose to fetch items filtered by a user query.
 *
 * The page consist of a list and a search text field to look up
 */
class SearchFragment : Fragment() {

    private val viewModel: SearchViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        loadModule()

        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                // This could also be put in SearchScreen.kt as the body of a new composable
                // function that takes viewModel and context as parameter.
                SearchScreen(
                    uiState = viewModel.uiState,
                    onQueryChanged = { query ->
//                        viewModel.listProducts(query = query)
                        viewModel.loadProducts(query = query)
                    },
                    onItemClickedListener = { product ->
                        // This could also call a EventViewModel, if necessary the MainActivity
                        // to make the toast.
                        Toast.makeText(
                            requireContext(),
                            "Item ${product.id} clicked.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                )
            }
        }
    }
}


