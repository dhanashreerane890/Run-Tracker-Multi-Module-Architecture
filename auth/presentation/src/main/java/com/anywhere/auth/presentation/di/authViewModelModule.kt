package com.anywhere.auth.presentation.di

import com.anywhere.auth.presentation.login.LoginViewModel
import com.anywhere.auth.presentation.register.RegisterViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val authViewModelModule = module {
    viewModelOf(::LoginViewModel)
    viewModelOf(::RegisterViewModel)
}