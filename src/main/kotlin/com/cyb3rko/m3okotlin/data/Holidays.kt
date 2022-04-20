package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HolidaysCountriesResponse(val countries: List<HolidaysCountry>) {

    @Serializable
    data class HolidaysCountry(val code: String, val name: String)
}

@Serializable
internal data class HolidaysListRequest(
    @SerialName("country_code")
    val countryCode: String,
    val year: Int
)

@Serializable
data class HolidaysListResponse(val holidays: List<HolidaysEntry>) {

    @Serializable
    data class HolidaysEntry(
        @SerialName("country_code")
        val countryCode: String,
        val date: String,
        @SerialName("local_name")
        val localName: String,
        val name: String,
        val regions: List<String>,
        val types: List<String>
    )
}