package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.WeatherForecastRequest
import com.cyb3rko.m3okotlin.data.WeatherForecastResponse
import com.cyb3rko.m3okotlin.data.WeatherNowRequest
import com.cyb3rko.m3okotlin.data.WeatherNowResponse
import io.ktor.client.request.*

private const val SERVICE = "weather"

object WeatherService {

    suspend fun forecast(location: String, days: Int = 1): WeatherForecastResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Forecast")) {
            body = WeatherForecastRequest(days, location)
        }
    }

    suspend fun now(location: String): WeatherNowResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Now")) {
            body = WeatherNowRequest(location)
        }
    }
}