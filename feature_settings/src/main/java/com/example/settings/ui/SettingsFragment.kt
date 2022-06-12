package com.example.settings.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.poc.core.data.preference.Theme
import com.example.settings.R
import com.example.settings.databinding.SettingsFragmentBinding
import com.example.settings.loadModules
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * This class is a proof-of-concept of a Fragment that uses a function initView
 * to update a View
 */
class SettingsFragment : Fragment(R.layout.settings_fragment) {

    private val viewModel: SettingsViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        loadModules()

        // Binding
        val binding = SettingsFragmentBinding.bind(view)

        // Observe UI state
        viewModel.uiState
            .onEach { state -> initView(binding, state) }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    // Functional implementation of initView similar to Compose,
    // but the state is manually checked and binding is manually done
    private fun initView(binding: SettingsFragmentBinding, state: UiState) {

        when (state) {
            UiState.None -> {
            }
            is UiState.Success -> {
                // Do the binding
                binding.themeTextView.text = state.theme.name
                binding.notificationTextView.text = state.isNotificationEnabled.toString()
            }
            is UiState.Error -> {}
            is UiState.Loading -> {
            }
        }
    }

    sealed class UiState {
        object None : UiState()

        data class Loading(val progress: Int?) : UiState()

        data class Success(
            val theme: Theme = Theme.SYSTEM,
            val isNotificationEnabled: Boolean = false
        ) : UiState()

        data class Error(val exception: Exception) : UiState()

        companion object {
            val UiState.success: Success get() = (this as? Success) ?: Success()
        }
    }
}