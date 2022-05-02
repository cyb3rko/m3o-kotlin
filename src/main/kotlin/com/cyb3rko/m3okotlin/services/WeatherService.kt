package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.WeatherForecastRequest
import com.cyb3rko.m3okotlin.data.WeatherForecastResponse
import com.cyb3rko.m3okotlin.data.WeatherNowRequest
import com.cyb3rko.m3okotlin.data.WeatherNowResponse
import io.ktor.client.request.*

private const val SERVICE = "weather"

/**
 * **Real time weather forecast**
 *
 * Get real time weather information including historic and future forecast
 * data.
 *
 * @since 0.1.0
 */
object WeatherService {

    /**
     * Get the weather forecast for the next 1-10 days
     * @since 0.1.0
     */
    suspend fun forecast(location: String, days: Int = 1): WeatherForecastResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Forecast")) {
            body = WeatherForecastRequest(days, location)
        }
    }

    /**
     * Get the current weather report for a location by postcode, city, zip
     * code, ip address
     * @since 0.1.0
     */
    suspend fun now(location: String): WeatherNowResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Now")) {
            body = WeatherNowRequest(location)
        }
    }
}
