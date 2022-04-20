package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.HolidaysCountriesResponse
import com.cyb3rko.m3okotlin.data.HolidaysListRequest
import com.cyb3rko.m3okotlin.data.HolidaysListResponse
import io.ktor.client.request.*

private const val SERVICE = "holidays"

object HolidaysService {

    suspend fun countries(): HolidaysCountriesResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Countries"))
    }

    suspend fun list(countryCode: String, year: Int): HolidaysListResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "List")) {
            body = HolidaysListRequest(countryCode, year)
        }
    }
}