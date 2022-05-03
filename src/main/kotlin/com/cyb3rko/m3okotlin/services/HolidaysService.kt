package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.HolidaysCountriesResponse
import com.cyb3rko.m3okotlin.data.HolidaysCountriesResponse.HolidaysCountry
import com.cyb3rko.m3okotlin.data.HolidaysListRequest
import com.cyb3rko.m3okotlin.data.HolidaysListResponse
import io.ktor.client.request.*

private const val SERVICE = "holidays"

/**
 * **Find the holidays observed in a particular country**
 *
 * List holidays observed in a country. Holidays may be at the country or
 * region level.
 *
 * @since 0.1.0
 */
object HolidaysService {

    /**
     * Get the list of countries that are supported by this API
     * @since 0.1.0
     */
    suspend fun countries(): HolidaysCountriesResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Countries"))
    }

    /**
     * List the holiday dates for a given country and year
     * @since 0.1.0
     */
    suspend fun list(countryCode: String, year: Int): HolidaysListResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "List")) {
            body = HolidaysListRequest(countryCode, year)
        }
    }

    suspend fun HolidaysCountry.list(year: Int) = list(this.code, year)
}
