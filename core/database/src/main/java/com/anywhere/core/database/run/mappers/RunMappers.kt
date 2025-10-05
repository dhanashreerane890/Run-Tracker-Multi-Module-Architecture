package com.anywhere.core.database.run.mappers

import com.anywhere.core.database.run.entity.RunEntity
import com.anywhere.core.domain.run.Run
import java.time.Instant
import java.time.ZoneId
import java.util.UUID
import kotlin.time.Duration.Companion.milliseconds


fun RunEntity.toRun(): Run {
    return Run(
        id = id,
        duration = durationMillis.milliseconds,
        dateTimeUtc = Instant.parse(dateTimeUtc)
            .atZone(ZoneId.of("UTC")),
        distanceMeters = distanceMeters,
        maxSpeedKmh = maxSpeedKmh,
        totalElevationMeters = totalElevationMeters,
        mapPictureUrl = mapPictureUrl,
        avgHeartRate = avgHeartRate,
        maxHeartRate = maxHeartRate
    )
}


fun Run.toRunEntity(): RunEntity {
    return RunEntity(
        id = id ?: UUID.randomUUID().toString(),
        durationMillis = duration.inWholeMilliseconds,
        maxSpeedKmh = maxSpeedKmh,
        dateTimeUtc = dateTimeUtc.toInstant().toString(),
        distanceMeters = distanceMeters,
        avgSpeedKmh = avgSpeedKmh,
        totalElevationMeters = totalElevationMeters,
        mapPictureUrl = mapPictureUrl,
        avgHeartRate = avgHeartRate,
        maxHeartRate = maxHeartRate
    )
}