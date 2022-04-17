package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

// Requests & Responses + Data (single use)

@Serializable
internal data class AnalyticsDeleteRequest(val name: String)

@Serializable
data class AnalyticsDeleteResponse(val event: AnalyticsEvent)

@Serializable
data class AnalyticsListResponse(val events: List<AnalyticsEvent>)

@Serializable
internal data class AnalyticsReadRequest(val name: String)

@Serializable
data class AnalyticsReadResponse(val event: AnalyticsEvent)

@Serializable
internal data class AnalyticsTrackRequest(val name: String)

// Data (multiple use)

@Serializable
data class AnalyticsEvent(
    val created: String,
    val name: String,
    val value: String
)