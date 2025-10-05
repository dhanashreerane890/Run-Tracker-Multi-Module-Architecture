package com.anywhere.auth.domain

import com.anywhere.core.domain.util.DataError
import com.anywhere.core.domain.util.EmptyResult


interface AuthRepository {
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
    suspend fun login(email: String, password: String): EmptyResult<DataError.Network>
}