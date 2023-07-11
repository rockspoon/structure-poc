package com.example.poc.auth_pin_code.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.poc.auth_pin_code.domain.SignInWithPinCodeUseCase
import com.example.poc.core.domain.Result
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AuthPinCodeViewModel(
    private val signInWithPinCodeUseCase: SignInWithPinCodeUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<AuthPinCodeFragment.UiState> =
        MutableStateFlow(AuthPinCodeFragment.UiState.None)
    val uiState: StateFlow<AuthPinCodeFragment.UiState> = _uiState

    private var authJob: Job? = null

    fun authWithPinCode(pinCode: String, key: String, deviceId: String) {
        authJob?.cancel()
        authJob = viewModelScope.launch {
            signInWithPinCodeUseCase.invoke(pinCode = pinCode, key = key, deviceId = deviceId)
                .collect { result ->
                    when (result) {
                        is Result.Error -> updateStateWithError(result.throwable)
                        is Result.Loading -> _uiState.update {
                            AuthPinCodeFragment.UiState.Loading(progress = result.progress)
                        }

                        is Result.Success -> _uiState.update {
                            AuthPinCodeFragment.UiState.Success
                        }

                        else -> _uiState.update { AuthPinCodeFragment.UiState.None }
                    }
                }
        }
    }

    private fun updateStateWithError(throwable: Throwable) {
        _uiState.update {
            AuthPinCodeFragment.UiState.Error(
                throwable = throwable,
                pinCodeBtnEnabled = it.pinCodeBtnEnabled
            )
        }
    }

    fun onPinCodeChanged(pinCode: String) {
        _uiState.update {
            when (it) {
                is AuthPinCodeFragment.UiState.None -> AuthPinCodeFragment.UiState.Idle(pinCode.length == 4)
                is AuthPinCodeFragment.UiState.Idle -> AuthPinCodeFragment.UiState.Idle(pinCode.length == 4)
                is AuthPinCodeFragment.UiState.Loading -> it
                is AuthPinCodeFragment.UiState.Success -> it
                is AuthPinCodeFragment.UiState.Error -> it.copy(pinCodeBtnEnabled = pinCode.length == 4)
            }
        }
    }
}