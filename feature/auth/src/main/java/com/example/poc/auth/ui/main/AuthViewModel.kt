package com.example.poc.auth.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.poc.auth.domain.SignInWithPasswordUseCase
import com.example.poc.core.data.user.User
import com.example.poc.core.domain.base.UseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class AuthViewModel constructor(
    private val signInWithPasswordUseCase: SignInWithPasswordUseCase
) : ViewModel() {

    val user = User(id = 1, givenName = "Jon", familyName = "Snow")

    private val _uiState: MutableStateFlow<AuthFragment.UiState> =
        MutableStateFlow(AuthFragment.UiState.None)
    val uiState: StateFlow<AuthFragment.UiState> = _uiState

    private var signInJob: Job? = null

    fun signUp() {
        signInJob?.cancel()

        signInJob = signInWithPasswordUseCase(SignInWithPasswordUseCase.Params(user.email, user.password))
            .onEach { result ->
                when (result) {
                    is UseCase.Result.Error -> _uiState.value =
                        AuthFragment.UiState.Error(exception = result.exception)
                    is UseCase.Result.Loading -> _uiState.value =
                        AuthFragment.UiState.Loading(progress = result.progress)
                    is UseCase.Result.Success -> _uiState.value =
                        AuthFragment.UiState.Success
                    else -> _uiState.value = AuthFragment.UiState.None
                }
            }
            .launchIn(viewModelScope)
    }
}