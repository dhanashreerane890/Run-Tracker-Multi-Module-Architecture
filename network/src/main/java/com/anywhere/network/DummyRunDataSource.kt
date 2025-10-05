package com.anywhere.network

object DummyRunDataSource {
    //dummy data
    fun getRunDataList(): List<RunDto> {
        return listOf(
            RunDto(
                id = "run1",
                dateTimeUtc = "2025-10-02T08:00:00Z",
                durationMillis = 3600000,
                distanceMeters = 10000,
                lat = 40.7128,
                long = -74.0060,
                avgSpeedKmh = 10.0,
                maxSpeedKmh = 15.0,
                totalElevationMeters = 50,
                mapPictureUrl = "https://i.sstatic.net/L6IpM.png",
                avgHeartRate = 140,
                maxHeartRate = 160
            ),
            RunDto(
                id = "run2",
                dateTimeUtc = "2025-10-01T07:30:00Z",
                durationMillis = 5400000,
                distanceMeters = 15000,
                lat = 34.0522,
                long = -118.2437,
                avgSpeedKmh = 10.0,
                maxSpeedKmh = 16.0,
                totalElevationMeters = 70,
                mapPictureUrl = "https://i.sstatic.net/L6IpM.png",
                avgHeartRate = 135,
                maxHeartRate = 155
            ),
            RunDto(
                id = "run3",
                dateTimeUtc = "2025-09-30T06:45:00Z",
                durationMillis = 2700000,
                distanceMeters = 8000,
                lat = 51.5074,
                long = -0.1278,
                avgSpeedKmh = 11.0,
                maxSpeedKmh = 14.0,
                totalElevationMeters = 30,
                mapPictureUrl = "https://i.sstatic.net/L6IpM.png",
                avgHeartRate = 130,
                maxHeartRate = 150
            ),
            RunDto(
                id = "run4",
                dateTimeUtc = "2025-09-29T18:20:00Z",
                durationMillis = 4500000,
                distanceMeters = 12000,
                lat = 48.8566,
                long = 2.3522,
                avgSpeedKmh = 9.5,
                maxSpeedKmh = 13.5,
                totalElevationMeters = 40,
                mapPictureUrl = "https://i.sstatic.net/L6IpM.png",
                avgHeartRate = 138,
                maxHeartRate = 158
            ),
            RunDto(
                id = "run5",
                dateTimeUtc = "2025-09-28T20:10:00Z",
                durationMillis = 6000000,
                distanceMeters = 20000,
                lat = 35.6895,
                long = 139.6917,
                avgSpeedKmh = 12.0,
                maxSpeedKmh = 18.0,
                totalElevationMeters = 80,
                mapPictureUrl = "https://i.sstatic.net/L6IpM.png",
                avgHeartRate = 145,
                maxHeartRate = 165
            )
        )
    }

    fun getRunData(): RunDto {
        return RunDto(
            id = "run1",
            dateTimeUtc = "2025-10-02T08:00:00Z",
            durationMillis = 3600000,
            distanceMeters = 10000,
            lat = 40.7128,
            long = -74.0060,
            avgSpeedKmh = 10.0,
            maxSpeedKmh = 15.0,
            totalElevationMeters = 50,
            mapPictureUrl = "https://lh3.googleusercontent.com/90TpARzCVIuf7v-vY9K2GaFU204Hq0us2sBL4So3ihcWRXYJ7rdx9ggMlI00SgzfUcFR_Ikxa2w-SzGJV6epMyRgn1P6th9oSBdWwv4=s0",
            avgHeartRate = 140,
            maxHeartRate = 160
        )
    }
}