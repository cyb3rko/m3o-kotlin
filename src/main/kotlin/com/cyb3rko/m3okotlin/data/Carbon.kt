package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
data class CarbonResponse(
    val metric: String,
    val projects: List<Project>,
    val tonnes: Float,
    val units: Int
) {

    @Serializable
    data class Project(
        val name: String,
        val percentage: Int,
        val tonnes: Float
    )
}