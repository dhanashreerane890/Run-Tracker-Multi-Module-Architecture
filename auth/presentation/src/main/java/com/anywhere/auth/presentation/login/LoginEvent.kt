package com.anywhere.auth.presentation.login

import com.anywhere.core.presentation.ui.UiText

sealed interface LoginEvent {
    data class Error(val error: UiText) : LoginEvent
    data object LoginSuccess : LoginEvent
}