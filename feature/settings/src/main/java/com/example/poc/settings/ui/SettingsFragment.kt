package com.example.poc.settings.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.poc.core.data.preferences.Theme
import com.example.poc.core.ui.event.EventViewModel
import com.example.poc.core.ui.event.FeatureSettingsEvent
import com.example.poc.settings.R
import com.example.poc.settings.databinding.SettingsFragmentBinding
import com.example.poc.settings.loadModules
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * This class is a proof-of-concept of a Fragment that uses a function initView
 * to update a View
 */
class SettingsFragment : Fragment(R.layout.settings_fragment) {

    private val viewModel: SettingsViewModel by viewModel()

    private val eventViewModel: EventViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // Dependency injection
        loadModules()

        // Binding
        val binding = SettingsFragmentBinding.bind(view).apply {

            themeSwitch.setOnCheckedChangeListener { _, isChecked ->
                val theme = if (isChecked) Theme.DARK
                else Theme.SYSTEM
                viewModel.setTheme(theme)
            }

            notificationSwitch.setOnCheckedChangeListener { _, isChecked ->
                viewModel.setIsNotificationEnabled(isChecked)
            }
            logout.setOnClickListener {
                viewModel.logout()
            }
        }

        // UI state
        viewModel.uiState
            .onEach { state -> initView(binding, state) }
            .launchIn(viewLifecycleOwner.lifecycleScope)

        viewModel.uiState
            .filter { it is UiState.Error }
            .onEach { state -> initView(binding, state) }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    // Functional implementation of initView similar to Compose,
    // but the state is manually checked and binding is manually done
    private fun initView(binding: SettingsFragmentBinding, state: UiState) {

        when (state) {
            UiState.None -> {}
            is UiState.Success -> {
                binding.themeSwitch.isChecked = state.theme == Theme.DARK
                binding.themeTextView.text = state.theme.name
                binding.notificationSwitch.isChecked = state.isNotificationEnabled
                binding.notificationTextView.text = state.isNotificationEnabled.toString()
            }

            is UiState.Error -> {
                eventViewModel.postEvent(FeatureSettingsEvent.OnPermissionRequired)
            }

            is UiState.Loading -> {}
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