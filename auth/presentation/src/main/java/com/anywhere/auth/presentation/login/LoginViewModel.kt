package com.anywhere.auth.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anywhere.auth.domain.DummyAuthRepository
import com.anywhere.auth.presentation.R
import com.anywhere.core.presentation.ui.UiText
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch


class LoginViewModel(
    private val authRepository: DummyAuthRepository,
) : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set


    private val eventChannel = Channel<LoginEvent>()
    val events = eventChannel.receiveAsFlow()


    fun onAction(action: LoginAction) {
        when (action) {
            LoginAction.OnLoginClick -> login()
            LoginAction.OnTogglePasswordVisibility -> {
                state = state.copy(
                    isPasswordVisible = !state.isPasswordVisible
                )
            }

            else -> Unit
        }
    }


    private fun login() {
        viewModelScope.launch {
            state = state.copy(isLoggingIn = true)
            if (state.email.text.toString().isEmpty()) {
                eventChannel.send(
                    LoginEvent.Error(
                        UiText.StringResource(R.string.error_email_field_cannot_be_empty)
                    )
                )
                state = state.copy(isLoggingIn = false)
                return@launch
            } else if (state.password.text.toString().isEmpty()) {
                eventChannel.send(
                    LoginEvent.Error(
                        UiText.StringResource(R.string.error_password_field_cannot_be_empty)
                    )
                )
                state = state.copy(isLoggingIn = false)
                return@launch
            }
            val result = authRepository.login(
                email = state.email.text.toString().trim(),
                password = state.password.text.toString()
            )
            state = state.copy(isLoggingIn = false)

            result.fold(
                onSuccess = {
                    eventChannel.send(LoginEvent.LoginSuccess)

                },
                onFailure = { _ ->
                    eventChannel.send(
                        LoginEvent.Error(
                            UiText.StringResource(R.string.error_email_password_incorrect)
                        )
                    )
                }
            )
        }
    }
}