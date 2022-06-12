package com.example.home.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.home.R
import com.example.home.databinding.HomeFragmentBinding
import com.example.home.loadModules
import com.example.poc.core.data.user.User
import com.example.poc.ui.MainActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment(R.layout.home_fragment){

    private val viewModel: HomeViewModel by viewModel()

    private lateinit var binding: HomeFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // Initialize the dependency injection modules for this project module
        loadModules()

        // Setup UI
        binding = HomeFragmentBinding.bind(view)

        // Observe UI state
        viewModel.uiState.onEach { uiState ->
            when (uiState) {
                UiState.None -> {
                }
                is UiState.Loading -> {
                }
                is UiState.Success -> {
                    updateGreetings(uiState.item)
                }
                is UiState.Error -> {
                }
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun updateGreetings(user: User){
        binding.greetingsTextView.text = getString(R.string.greetings_template, user.givenName)
    }

    sealed class UiState {
        object None : UiState()
        data class Loading(val progress: Int?) : UiState()
        data class Success(val item: User) : UiState()
        data class Error(val throwable: Throwable) : UiState()
    }
}