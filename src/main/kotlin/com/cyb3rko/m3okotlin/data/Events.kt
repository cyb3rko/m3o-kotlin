package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

// Requests & Responses + Data (single use)

@Serializable
internal data class EventsConsumeRequest(
    val group: String,
    val offset: String,
    val topic: String
)

@Serializable
data class EventsConsumeResponse(
    val id: String,
    val message: EventsMessage,
    val timestamp: String,
    val topic: String
)

@Serializable
internal data class EventsPublishRequest(val message: EventsMessage, val topic: String)

@Serializable
internal data class EventsReadRequest(
    val limit: Int,
    val offset: Int,
    val topic: String
)

@Serializable
data class EventsReadResponse(val events: List<Event>) {

    @Serializable
    data class Event(val id: String, val message: EventsMessage)
}

// Data (multiple use)

@Serializable
data class EventsMessage(
    val id: String,
    val type: String,
    val user: String
)
