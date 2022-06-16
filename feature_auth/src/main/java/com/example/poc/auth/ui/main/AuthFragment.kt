package com.example.poc.auth.ui.main

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.poc.auth.R
import com.example.poc.auth.databinding.AuthFragmentBinding
import com.example.poc.auth.domain.SignUpWithPasswordUseCase
import com.example.poc.auth.loadModules
import com.example.poc.core.data.user.User
import com.example.poc.ui.MainActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel


class AuthFragment : Fragment(R.layout.auth_fragment) {

    private val viewModel: AuthViewModel by viewModel()

    private lateinit var binding: AuthFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // Initialize the dependency injection modules for this project module
        loadModules()

        // Setup UI
        binding = AuthFragmentBinding.bind(view)
        binding.passwordEditText.setText(viewModel.user.password)
        binding.authButton.setOnClickListener {
            viewModel.user.password = binding.passwordEditText.text.toString()
            viewModel.user.email = binding.emailEditText.text.toString()
            viewModel.signUp()
        }

        // Observe UI state
        viewModel.uiState.onEach { uiState ->
            when (uiState) {
                UiState.None -> {
                    updateProgressIndicator(null)
                    updateErrorMessages(null)
                }
                is UiState.Loading -> {
                    updateProgressIndicator(uiState.progress)
                    updateErrorMessages(null)
                }
                is UiState.Success -> {
                    updateProgressIndicator(null)
                    updateErrorMessages(null)
                    notifyOnAuthSuccess()
                }
                is UiState.Error -> {
                    updateProgressIndicator(null)
                    updateErrorMessages(uiState.exception)
                }
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    /**
     * Progress equals to 0 means indeterminate, null means hide it, and between 0 and 100 means
     * executing.
     */
    private fun updateProgressIndicator(progress: Int?) {
        when (progress) {
            null -> {
                binding.progressIndicator.isVisible = false
                binding.authButton.isVisible = true
            }
            0 -> {
                binding.progressIndicator.progress = progress
                binding.progressIndicator.isIndeterminate = true
            }
            else -> {
                binding.progressIndicator.progress = progress
                binding.progressIndicator.isIndeterminate = false
            }
        }
    }

    private fun updateErrorMessages(t: Throwable? = null) {

        // It concerns to the UI layer, specifically activities and fragments, translate the message
        // from technical English to the user language. The specific message should be provided
        // by the design team and should consider clarity to the target users and align with the
        // intonation of the general marketing strategy. Here we used a informal one, which is never
        // allowed in the exception message itself. The message for the user must contain
        // information suggesting how the user should respond, like "Try later" for unknown errors
        // that we should fix or indicating how to insert valid inputs.
        when (t) {
            is SignUpWithPasswordUseCase.UserPasswordTooShortException -> {
                val message = getText(R.string.error_authentication_password_short)
                binding.passwordInputLayout.error = message
            }
            null -> {
                binding.passwordInputLayout.error = null
            }
            else -> {
                val message = getText(R.string.error_authentication_unknown)
                Snackbar.make(requireView(), message, Snackbar.LENGTH_INDEFINITE).show()
            }
        }
    }

    private fun notifyOnAuthSuccess() {
        (activity as MainActivity).onAuthSuccess()
    }

    sealed class UiState {
        object None : UiState()
        data class Loading(val progress: Int?) : UiState()
        data class Success(val item: User) : UiState()
        data class Error(val exception: Exception) : UiState()
    }
}