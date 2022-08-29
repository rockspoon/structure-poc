package com.example.poc.auth.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.poc.auth.domain.SignUpWithPasswordUseCase
import com.example.poc.core.data.user.User
import com.example.poc.core.domain.base.UseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*

class AuthViewModel constructor(
    private val signUpWithPasswordUseCase: SignUpWithPasswordUseCase,
    emailInputDelegate: EmailInputDelegate
) : ViewModel(), EmailInputDelegate by emailInputDelegate {

    val user = User(id = 1, givenName = "Jon", familyName = "Snow")

    private val _uiState: MutableStateFlow<AuthFragment.UiState> =
        MutableStateFlow(AuthFragment.UiState.None)
    val uiState: StateFlow<AuthFragment.UiState> = _uiState

    private var signUpJob: Job? = null

    init {
        // Ignore success because the UI don't change when email is valid. If did
        // we would need to modify the AuthFragment.UiState to have an valid email
        // attribute.

        // Note that we don't deliver directly the result to the fragment. The fragment
        // is only observing the UiState to keep it as a single source of truth. Instead
        // we update the StateFlow<UiState> with the validation error. This will trigger
        // a new emission of UiState to the fragment

        // Here I am just replacing for simplicity, but there is an kotlin official
        // extension to update atomically the MutableStateFlow when you don't want
        // to miss the other attributes of the state: MutableStateFlow<T>.update()
        observeValidateEmailResult.onEach { result ->
            if (result is UseCase.Result.Error) _uiState.value =
                AuthFragment.UiState.Error(emailInputException = result.exception)
        }.launchIn(viewModelScope)
    }

    fun signUp() {
        signUpJob?.cancel()
        signUpJob = signUpWithPasswordUseCase(SignUpWithPasswordUseCase.Params(user))
            .onEach { result ->
                when (result) {
                    is UseCase.Result.Error -> _uiState.value =
                        AuthFragment.UiState.Error(exception = result.exception)
                    is UseCase.Result.Loading -> _uiState.value =
                        AuthFragment.UiState.Loading(progress = result.progress)
                    is UseCase.Result.Success -> _uiState.value =
                        AuthFragment.UiState.Success(item = result.data)
                    else -> _uiState.value = AuthFragment.UiState.None
                }
            }
            .launchIn(viewModelScope)
    }
}

// I put all this delegate here for didatic reason. It belongs on the :core_ui module so
// other features can use it
interface EmailInputDelegate {
    /**
     * Request a email to validate.
     */
    // This will be called by the Fragment whenever it wants to validate the email, usually when
    // the input text lose focus.
    fun validateEmail(email: String)

    /**
     * Flow to observe the result of an email validation
     */
    // We will deliver the result in this flow, but not to the fragment... The fragment will
    // receive UiState from the view model
    val observeValidateEmailResult: StateFlow<UseCase.Result<Unit>>
}

class EmailInputDelegateImpl constructor(
    val validateEmailUseCase: ValidateEmailUseCase,
) : EmailInputDelegate {

    override fun validateEmail(email: String) {
        _observeValidateEmailResult.value = validateEmailUseCase(email)
    }

    // Default here is success, which make no change to the interface.
    private val _observeValidateEmailResult: MutableStateFlow<UseCase.Result<Unit>> =
        MutableStateFlow(UseCase.Result.Success(Unit))
    override val observeValidateEmailResult = _observeValidateEmailResult
}

// I put this use case here for didatic reason. It belongs on the :core_domain module
// so other features can use it
class ValidateEmailUseCase {
    /**
     * @param parameters the email to be validated
     */
    // The parameters could be an data class with many attributes. Here we keep it simple.
    operator fun invoke(parameters: String): UseCase.Result<Unit> {
        // Dummy implementation, use real regex instead
        return when {
            parameters.isBlank() -> UseCase.Result.Error(BlankEmailException)
            parameters.contains("@") -> UseCase.Result.Success(Unit)
            else -> UseCase.Result.Error(InvalidEmailException(parameters))
        }
    }

    class InvalidEmailException(email: String) :
        RuntimeException("Email $email is invalid. Emails should contain '@' symbol.")

    object BlankEmailException :
        RuntimeException("Email is blank.")

}