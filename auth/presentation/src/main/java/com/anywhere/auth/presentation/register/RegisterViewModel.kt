package com.anywhere.auth.presentation.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anywhere.auth.domain.DummyAuthRepository
import com.anywhere.auth.domain.UserDataValidator
import com.anywhere.auth.presentation.R
import com.anywhere.core.presentation.ui.UiText
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val userDataValidator: UserDataValidator,
    private val repository: DummyAuthRepository
) : ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    private val eventChannel = Channel<RegisterEvent>()
    val events = eventChannel.receiveAsFlow()

    init {
        validationForCredentialsInput()
    }

    private fun validationForCredentialsInput() {
        combine(
            snapshotFlow { state.email.text },
            snapshotFlow { state.password.text }
        ) { email, password ->
            val trimmedEmail = email.toString().trim()
            val isValidEmail = userDataValidator.isValidEmail(trimmedEmail)
            val passwordValidationState = userDataValidator.validatePassword(password.toString())

            state = state.copy(
                isEmailValid = isValidEmail,
                passwordValidationState = passwordValidationState,
                canRegister = isValidEmail &&
                        passwordValidationState.isValidPassword &&
                        !state.isRegistering
            )
        }.launchIn(viewModelScope)
    }

    fun onAction(action: RegisterAction) {
        when (action) {
            RegisterAction.OnRegisterClick -> register()
            RegisterAction.OnTogglePasswordVisibilityClick -> {
                state = state.copy(
                    isPasswordVisible = !state.isPasswordVisible
                )
            }

            else -> Unit
        }
    }

    private fun register() {
        viewModelScope.launch {
            state = state.copy(isRegistering = true)
            val result = repository.register(
                email = state.email.text.toString().trim(),
                password = state.password.text.toString()
            )
            state = state.copy(isRegistering = false)

            result.fold(
                onSuccess = {
                    eventChannel.send(RegisterEvent.RegistrationSuccess)
                },
                onFailure = { exception ->
                    val message = if (exception.message?.contains("exists") == true) {
                        UiText.StringResource(R.string.error_email_exists)
                    } else {
                        UiText.DynamicString(exception.message ?: "Unknown error")
                    }
                    eventChannel.send(RegisterEvent.Error(message))
                }
            )
        }
    }

}
