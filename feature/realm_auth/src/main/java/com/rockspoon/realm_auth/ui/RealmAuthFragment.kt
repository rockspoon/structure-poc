package com.rockspoon.realm_auth.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.poc.core.ui.common.BindableFragment
import com.example.poc.core.ui.event.EventViewModel
import com.example.poc.core.ui.event.FeatureAuthEvent
import com.example.poc.realm_auth.R
import com.example.poc.realm_auth.databinding.RealmAuthFragmentBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RealmAuthFragment : BindableFragment<RealmAuthFragmentBinding>() {

    private val authViewModel: RealmAuthViewModel by viewModel()

    private val eventViewModel: EventViewModel by activityViewModel()

    override fun viewBindingInflate(): RealmAuthFragmentBinding =
        RealmAuthFragmentBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.authButton.setOnClickListener {
            authViewModel.auth(
                binding.emailEditText.text.toString(),
                binding.passwordEditText.text.toString()
            )
        }

        authViewModel.uiState.onEach { uiState ->
            when (uiState) {
                RealmAuthViewModel.UiState.None -> {
                    updateProgressIndicator(null)
                    updateErrorMessages(null)
                }

                is RealmAuthViewModel.UiState.Loading -> {
                    updateProgressIndicator(
                        uiState.progress ?: RealmAuthViewModel.UiState.Loading.INDETERMINATE
                    )
                    updateErrorMessages(null)
                }

                is RealmAuthViewModel.UiState.Success -> {
                    updateProgressIndicator(null)
                    updateErrorMessages(null)
                    notifyOnAuthSuccess()
                }

                is RealmAuthViewModel.UiState.Error -> {
                    updateProgressIndicator(null)
                    updateErrorMessages(uiState.exception)
                }
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun updateProgressIndicator(progress: Int?) {
        binding.authButton.isEnabled = progress == null
        binding.progressIndicator.isVisible = progress != null
        binding.progressIndicator.isIndeterminate =
            progress == RealmAuthViewModel.UiState.Loading.INDETERMINATE
        binding.progressIndicator.progress = progress ?: 0
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
            null -> {
                binding.passwordInputLayout.error = null
            }

            else -> {
                val message = getString(R.string.error_authentication)
                Snackbar.make(requireView(), message, Snackbar.LENGTH_LONG).show()
            }
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


}