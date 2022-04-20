package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.PrayerRequest
import com.cyb3rko.m3okotlin.data.PrayerResponse
import io.ktor.client.request.*

private const val SERVICE = "prayer"

object PrayerService {

    suspend fun times(
        date: String = "",
        days: Int = 1,
        latitude: Double = 0.0,
        location: String = "",
        longitude: Double = 0.0,
    ): PrayerResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Times")) {
            body = PrayerRequest(date, days, latitude, location, longitude)
        }
    }
}