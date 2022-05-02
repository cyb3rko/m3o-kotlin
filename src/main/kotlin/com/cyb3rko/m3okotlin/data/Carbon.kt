package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
data class CarbonResponse(
    val metric: String,
    val projects: List<CarbonProject>,
    val tonnes: Float,
    val units: Int
) {

    @Serializable
    data class CarbonProject(
        val name: String,
        val percentage: Int,
        val tonnes: Float
    )
}
