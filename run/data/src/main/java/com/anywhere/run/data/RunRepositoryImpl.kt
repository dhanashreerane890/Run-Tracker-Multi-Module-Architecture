package com.anywhere.run.data


import com.anywhere.core.domain.util.DataError
import com.anywhere.core.domain.util.EmptyResult
import com.anywhere.core.domain.util.Result
import com.anywhere.core.domain.util.asEmptyDataResult
import com.anywhere.run.domain.IDummyRunDataSource
import com.anywhere.run.domain.LocalRunDataSource
import com.anywhere.run.domain.Run
import com.anywhere.run.domain.RunRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow

class RunRepositoryImpl(
    private val localRunDataSource: LocalRunDataSource,
    private val iDummyRunDataSource: IDummyRunDataSource,
    private val applicationScope: CoroutineScope,
) : RunRepository {

    override fun getRuns(): Flow<List<Run>> {
        return localRunDataSource.getRuns()
    }

    override suspend fun fetchRuns(): EmptyResult<DataError> {
        return when (val result = iDummyRunDataSource.getRuns()) {
            is Result.Error -> result.asEmptyDataResult()
            is Result.Success -> {
                applicationScope.async {
                    localRunDataSource.upsertRuns(result.data).asEmptyDataResult()
                }.await()
            }
        }
    }

    override suspend fun deleteAllRuns() {
        localRunDataSource.deleteAllRuns()
    }
}