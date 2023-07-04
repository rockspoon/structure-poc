package com.example.poc.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.poc.core.domain.user.ObserveUserUseCase
import com.example.poc.core.domain.base.UseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class HomeViewModel(
    observeUserUseCase: ObserveUserUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<HomeFragment.UiState> =
        MutableStateFlow(HomeFragment.UiState.None)
    val uiState: StateFlow<HomeFragment.UiState> = _uiState

    init {
        observeUserUseCase(ObserveUserUseCase.Params(1))
            .onEach { result ->
                when (result) {
                    is UseCase.Result.Error -> _uiState.value =
                        HomeFragment.UiState.Error(throwable = result.exception)
                    is UseCase.Result.Loading -> _uiState.value =
                        HomeFragment.UiState.Loading(progress = result.progress)
                    is UseCase.Result.Success -> _uiState.value =
                        HomeFragment.UiState.Success(item = result.data)
                    else -> _uiState.value = HomeFragment.UiState.None
                }
            }
            .launchIn(viewModelScope)
    }
}