package com.anywhere.core.database.run.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class RunEntity(
    val durationMillis: Long,
    val distanceMeters: Int,
    val dateTimeUtc: String,
    val avgSpeedKmh: Double,
    val maxSpeedKmh: Double,
    val totalElevationMeters: Int,
    val mapPictureUrl: String?,
    val avgHeartRate: Int?,
    val maxHeartRate: Int?,
    @PrimaryKey(autoGenerate = false)
    val id: String = UUID.randomUUID().toString()
)