package com.example.poc.home.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.poc.core.data.user.User
import com.example.poc.core.ui.common.BindableFragment
import com.example.poc.home.R
import com.example.poc.home.databinding.HomeFragmentBinding
import com.example.poc.home.loadModules
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BindableFragment<HomeFragmentBinding>() {

    private val viewModel: HomeViewModel by viewModel()

    override fun viewBindingInflate() = HomeFragmentBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // Initialize the dependency injection modules for this project module
        loadModules()

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

    private fun updateGreetings(user: User) {
        binding.greetingsTextView.text = getString(R.string.greetings_template, user.email)
    }

    sealed class UiState {
        object None : UiState()
        data class Loading(val progress: Int?) : UiState()
        data class Success(val item: User) : UiState()
        data class Error(val throwable: Throwable) : UiState()
    }
}