package com.example.poc.auth_pin_code.ui.main

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.lifecycleScope
import com.example.poc.auth_pin_code.R
import com.example.poc.auth_pin_code.databinding.AuthPinCodeFragmentBinding
import com.example.poc.auth_pin_code.loadModules
import com.example.poc.core.ui.common.BindableFragment
import com.example.poc.core.ui.event.EventViewModel
import com.example.poc.core.ui.event.FeatureAuthEvent
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthPinCodeFragment : BindableFragment<AuthPinCodeFragmentBinding>() {

    private val viewModel: AuthPinCodeViewModel by viewModel()

    private val eventViewModel: EventViewModel by sharedViewModel()

    override fun viewBindingInflate() = AuthPinCodeFragmentBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // Initialize the dependency injection modules for this project module
        loadModules()

        // Setup UI

        binding.pinCodeEditText.doAfterTextChanged { editable ->
            viewModel.onPinCodeChanged(editable.toString())
        }

        binding.authButton.setOnClickListener {
            //TODO by Oleg. add test_api_key file with venue api_key to use pin code authorization
            val key = resources.openRawResource(R.raw.test_api_key).bufferedReader().use {
                it.readText()
            }

            //TODO by Oleg. add test_device_id file with venue deviceId to use pin code authorization
            val deviceId = resources.openRawResource(R.raw.test_device_id).bufferedReader().use {
                it.readText()
            }

            viewModel.authWithPinCode(
                pinCode = binding.pinCodeEditText.text.toString(),
                key = key,
                deviceId = deviceId
            )
        }

        // Observe UI state
        viewModel.uiState.onEach { uiState ->
            binding.authButton.isEnabled = uiState.pinCodeBtnEnabled
            when (uiState) {
                UiState.None -> {
                    updateProgressIndicator(null)
                    updateErrorMessages(null)
                }

                is UiState.Idle -> {
                    updateProgressIndicator(null)
                    updateErrorMessages(null)
                }

                is UiState.Loading -> {
                    updateProgressIndicator(uiState.progress ?: UiState.Loading.INDETERMINATE)
                    updateErrorMessages(null)
                }

                is UiState.Success -> {
                    updateProgressIndicator(null)
                    updateErrorMessages(null)
                    notifyOnAuthSuccess()
                }

                is UiState.Error -> {
                    updateProgressIndicator(null)
                    updateErrorMessages(uiState.throwable)
                }
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    /**
     * Progress equals to -1 means INDETERMINATE, null means hide it, and between 0 and 100 means
     * executing.
     */
    private fun updateProgressIndicator(progress: Int?) {
        binding.progressIndicator.isVisible = progress != null
        binding.progressIndicator.isIndeterminate = progress == UiState.Loading.INDETERMINATE
        binding.progressIndicator.progress = progress ?: 0
    }

    private fun updateErrorMessages(t: Throwable? = null) {
        if (t != null) {
            val message = getText(R.string.error_authentication_unknown)
            Snackbar.make(requireView(), "$message ${t.message}", Snackbar.LENGTH_LONG).show()
        }

    }

    private fun notifyOnAuthSuccess() {
        // Note that we don't navigate to home screen. A feature module should be complete ignorant
        // about the reasons why it was invoked, this includes knowing what it will be done with
        // it's results, so make it call a function with explicitly naming indicating where to go
        // next would break this paradigm. Instead the feature only call a function indicating that
        // it's job is completed. The reason is because the feature should be treated as if it can
        // be invoked for multiple reasons. Now we are invoking authentication for the home screen,
        // but we could invoked it for seeing a credit card info, for example.
        eventViewModel.postEvent(
            FeatureAuthEvent.OnAuthenticationCompleted("fake_token")
        )
    }

    sealed class UiState {
        abstract val pinCodeBtnEnabled: Boolean

        object None : UiState() {
            override val pinCodeBtnEnabled: Boolean
                get() = false
        }

        data class Idle(
            override val pinCodeBtnEnabled: Boolean
        ) : UiState() {

        }

        data class Loading(val progress: Int?) : UiState() {
            override val pinCodeBtnEnabled: Boolean
                get() = false

            companion object {
                const val INDETERMINATE = -1
            }
        }

        object Success : UiState() {
            override val pinCodeBtnEnabled: Boolean
                get() = false
        }

        data class Error(val throwable: Throwable, override val pinCodeBtnEnabled: Boolean) :
            UiState()
    }
}