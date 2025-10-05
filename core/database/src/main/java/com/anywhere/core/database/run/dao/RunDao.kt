package com.anywhere.core.database.run.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.anywhere.core.database.run.entity.RunEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RunDao {

    @Upsert
    suspend fun upsertRuns(runs: List<RunEntity>)

    @Query("SELECT * FROM runentity ORDER BY dateTimeUtc DESC")
    fun getRuns(): Flow<List<RunEntity>>

    @Query("DELETE FROM runentity")
    suspend fun deleteAllRuns()
}