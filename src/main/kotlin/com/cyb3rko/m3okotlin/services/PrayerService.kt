package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.PrayerRequest
import com.cyb3rko.m3okotlin.data.PrayerResponse
import io.ktor.client.request.*

private const val SERVICE = "prayer"

/**
 * **Islamic prayer times**
 *
 * Prayer (salah) times for the religion of Islam. The daily obligatory prayers
 * collectively form the second of the five pillars in Islam, observed five
 * times every day at prescribed times. These are Fajr (observed at dawn), Zuhr
 * prayer (observed at noon), Asr (observed late in the afternoon), Maghrib
 * (observed at dusk), and Isha (observed after sunset).
 *
 * @since 0.1.0
 */
object PrayerService {

    /**
     * Get the prayer (salah) times for a location on a given date
     * @since 0.1.0
     */
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
