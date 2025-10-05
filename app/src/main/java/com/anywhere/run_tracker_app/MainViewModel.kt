package com.anywhere.run_tracker_app

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anywhere.core.database.user.dao.UserDao
import kotlinx.coroutines.launch

class MainViewModel(
    private val userDao: UserDao
) : ViewModel() {

    var state by mutableStateOf(MainState())
        private set

    init {
        viewModelScope.launch {
            state = state.copy(isCheckingAuth = true)
            state = state.copy(
                isLoggedIn = userDao.isLoggedIn()?.isLoggedIn == true
            )
            state = state.copy(isCheckingAuth = false)
        }
    }
}