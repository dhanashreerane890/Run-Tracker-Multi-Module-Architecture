package com.anywhere.run.presentation.run_overview.mapper

import com.anywhere.core.presentation.ui.formatted
import com.anywhere.core.presentation.ui.toFormattedHeartRate
import com.anywhere.core.presentation.ui.toFormattedKm
import com.anywhere.core.presentation.ui.toFormattedKmh
import com.anywhere.core.presentation.ui.toFormattedMeters
import com.anywhere.core.presentation.ui.toFormattedPace
import com.anywhere.run.domain.Run
import com.anywhere.run.presentation.run_overview.model.RunUi
import java.time.ZoneId
import java.time.format.DateTimeFormatter


fun Run.toRunUi(): RunUi {
    val dateTimeInLocalTime = dateTimeUtc
        .withZoneSameInstant(ZoneId.systemDefault())
    val formattedDateTime = DateTimeFormatter
        .ofPattern("MMM dd, yyyy - hh:mma")
        .format(dateTimeInLocalTime)

    val distanceKm = distanceMeters / 1000.0

    return RunUi(
        id = id!!,
        duration = duration.formatted(),
        dateTime = formattedDateTime,
        distance = distanceKm.toFormattedKm(),
        avgSpeed = avgSpeedKmh.toFormattedKmh(),
        maxSpeed = maxSpeedKmh.toFormattedKmh(),
        pace = duration.toFormattedPace(distanceKm),
        totalElevation = totalElevationMeters.toFormattedMeters(),
        mapPictureUrl = mapPictureUrl,
        avgHeartRate = avgHeartRate.toFormattedHeartRate(),
        maxHeartRate = maxHeartRate.toFormattedHeartRate()
    )
}