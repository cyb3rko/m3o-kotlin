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
    val location: String,
    val latitude: Double,
    val longitude: Double,
    val times: List<PrayerTime>
) {

    @Serializable
    data class PrayerTime(
        val date: String,
        val fajr: String,
        val sunrise: String,
        val zuhr: String,
        val asr: String,
        val maghrib: String,
        val isha: String
    )
}