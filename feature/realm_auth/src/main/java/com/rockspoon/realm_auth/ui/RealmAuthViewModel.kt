package com.rockspoon.realm_auth.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.poc.core.data.credentials.Credentials
import com.example.poc.core.domain.base.UseCase
import com.rockspoon.realm_auth.domain.AuthUseCase
import com.rockspoon.realm_auth.ui.RealmAuthViewModel.UiState.Loading.Companion.INDETERMINATE
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RealmAuthViewModel(
    private val authUserUseCase: AuthUseCase
) : ViewModel() {

    var authJob: Job? = null

    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState.None)
    val uiState: StateFlow<UiState> get() = _uiState


    fun auth(email: String, password: String) {
        authJob = viewModelScope.launch {
            if (email.isNotBlank() && password.isNotBlank()) {
                authUserUseCase(AuthUseCase.Params(email, password))
                    .collect { result ->
                        when (result) {
                            is UseCase.Result.Loading -> _uiState.update {
                                UiState.Loading(
                                    INDETERMINATE
                                )
                            }

                            is UseCase.Result.Error -> _uiState.update { UiState.Error(result.exception) }
                            is UseCase.Result.Success -> _uiState.update { UiState.Success(result.data) }
                            else -> _uiState.update { UiState.None }
                        }
                    }
            }
        }
    }

    sealed class UiState {
        object None : UiState()
        data class Loading(val progress: Int?) : UiState() {
            companion object {
                const val INDETERMINATE = -1
            }
        }

        data class Success(val item: Credentials?) : UiState()
        data class Error(val exception: Exception) : UiState()
    }

}
