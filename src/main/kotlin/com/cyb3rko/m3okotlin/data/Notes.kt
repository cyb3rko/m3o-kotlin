package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

// Requests & Responses + Data (single use)

@Serializable
internal data class NotesCreateRequest(val text: String, val title: String)

@Serializable
data class NotesCreateResponse(val note: NotesNote)

@Serializable
internal data class NotesDeleteRequest(val id: String)

@Serializable
data class NotesDeleteResponse(val note: NotesNote)

@Serializable
internal data class NotesEventsRequest(val id: String)

@Serializable
data class NotesEventsResponse(val event: String, val note: NotesNote)

@Serializable
data class NotesListResponse(val notes: List<NotesNote>)

@Serializable
internal data class NotesReadRequest(val id: String)

@Serializable
data class NotesReadResponse(val note: NotesNote)

@Serializable
internal data class NotesUpdateRequest(val note: NotesUpdate)

@Serializable
data class NotesUpdateResponse(val note: NotesNote)

// Data (multiple use)

@Serializable
data class NotesNote(
    val id: String,
    val created: String,
    val updated: String,
    val title: String,
    val text: String
)

@Serializable
data class NotesUpdate(
    val id: String,
    val text: String,
    val title: String
)
