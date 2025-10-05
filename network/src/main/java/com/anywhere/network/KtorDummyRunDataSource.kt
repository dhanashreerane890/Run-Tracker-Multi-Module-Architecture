package com.anywhere.network

import com.anywhere.core.domain.run.IDummyRunDataSource
import com.anywhere.core.domain.run.Run
import com.anywhere.core.domain.util.DataError
import com.anywhere.core.domain.util.Result
import kotlinx.coroutines.delay

class KtorDummyRunDataSource : IDummyRunDataSource {

    override suspend fun getRuns(): Result<List<Run>, DataError.Network> {
        delay(1500)// simulate network delay
        return Result.Success(DummyRunDataSource.getRunDataList().map { it.toRun() })

    }

    override suspend fun postRun(run: Run, mapPicture: ByteArray): Result<Run, DataError.Network> {
        delay(2000) // simulate network delay
        val result = DummyRunDataSource.getRunData()
        return Result.Success(result.toRun())
    }

}