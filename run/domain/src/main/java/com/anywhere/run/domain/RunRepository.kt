package com.anywhere.run.domain

import com.anywhere.core.domain.util.DataError
import com.anywhere.core.domain.util.EmptyResult
import kotlinx.coroutines.flow.Flow

interface RunRepository {
    fun getRuns(): Flow<List<Run>>
    suspend fun fetchRuns(): EmptyResult<DataError>
    suspend fun deleteAllRuns()
}