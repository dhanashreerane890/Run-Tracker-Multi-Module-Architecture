package com.anywhere.core.database.run

import androidx.room.Database
import androidx.room.RoomDatabase
import com.anywhere.core.database.run.dao.RunDao
import com.anywhere.core.database.run.entity.RunEntity

@Database(
    entities = [
        RunEntity::class
    ],
    version = 1
)
abstract class RunDatabase : RoomDatabase() {
    abstract val runDao: RunDao
}