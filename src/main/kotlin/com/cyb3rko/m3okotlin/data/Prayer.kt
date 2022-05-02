package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class PrayerRequest(
    val date: String,
    val days: Int,
    val latitude: Double,
    val location: String,
    val longitude: Double
)

@Serializable
data class PrayerResponse(
    val date: String,
    val days: Int,
    val latitude: Double,
    val location: String,
    val longitude: Double,
    val times: List<PrayerTime>
) {

    @Serializable
    data class PrayerTime(
        val asr: String,
        val date: String,
        val fajr: String,
        val isha: String,
        val maghrib: String,
        val sunrise: String,
        val zuhr: String
    )
}
