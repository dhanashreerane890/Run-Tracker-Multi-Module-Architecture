package com.anywhere.auth.data

import com.anywhere.auth.domain.DummyAuthRepository
import com.anywhere.core.database.user.dao.UserDao
import com.anywhere.core.database.user.entity.User

class DummyAuthRepositoryImpl(
    private val userDao: UserDao,
) : DummyAuthRepository {

    override suspend fun register(email: String, password: String): Result<Unit> {
        val existingUser = userDao.getUserByEmail(email)
        return if (existingUser != null) {
            Result.failure(Exception("User already exists"))
        } else {
            userDao.insertUser(User(email = email, password = password))
            Result.success(Unit)
        }
    }

    override suspend fun login(email: String, password: String): Result<Unit> {
        val user = userDao.getUserByEmail(email)
        return if (user == null || user.password != password) {
            Result.failure(Exception("Invalid credentials"))
        } else {
            userDao.insertUser(user.copy(isLoggedIn = true))
            Result.success(Unit)
        }
    }
}
