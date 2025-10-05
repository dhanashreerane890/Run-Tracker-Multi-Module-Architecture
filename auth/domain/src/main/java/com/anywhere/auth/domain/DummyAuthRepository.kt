package com.anywhere.auth.domain

interface DummyAuthRepository {
    suspend fun register(email: String, password: String): Result<Unit>
    suspend fun login(email: String, password: String): Result<Unit>
}