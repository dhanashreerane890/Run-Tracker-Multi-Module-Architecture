package com.anywhere.core.database.run

import com.anywhere.core.database.run.dao.RunDao
import com.anywhere.core.database.run.mappers.toRun
import com.anywhere.core.database.run.mappers.toRunEntity
import com.anywhere.core.domain.run.LocalRunDataSource
import com.anywhere.core.domain.run.Run
import com.anywhere.core.domain.run.RunId
import com.anywhere.core.domain.util.DataError
import com.anywhere.core.domain.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RoomLocalRunDataSource(
    private val runDao: RunDao
) : LocalRunDataSource {

    override fun getRuns(): Flow<List<Run>> {
        return runDao.getRuns()
            .map { runEntities ->
                runEntities.map { it.toRun() }
            }
    }

    override suspend fun upsertRuns(runs: List<Run>): Result<List<RunId>, DataError.Local> {
        return try {
            val entities = runs.map { it.toRunEntity() }
            runDao.upsertRuns(entities)
            Result.Success(entities.map { it.id })
        } catch (e: Exception) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun deleteAllRuns() {
        runDao.deleteAllRuns()
    }
}