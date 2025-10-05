package com.anywhere.network

import kotlinx.serialization.Serializable


@Serializable
data class CreateRunRequest(
    val durationMillis: Long,
    val distanceMeters: Int,
    val epochMillis: Long,
    val avgSpeedKmh: Double,
    val maxSpeedKmh: Double,
    val totalElevationMeters: Int,
    val avgHeartRate: Int?,
    val maxHeartRate: Int?,
    val id: String?
)