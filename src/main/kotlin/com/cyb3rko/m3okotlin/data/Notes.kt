package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

// Requests & Responses + Data (single use)

@Serializable
internal data class NotesCreateRequest(val text: String, val title: String)

@Serializable
data class NotesCreateResponse(val note: Note)

@Serializable
internal data class NotesDeleteRequest(val id: String)

@Serializable
data class NotesDeleteResponse(val note: Note)

@Serializable
internal data class NotesEventsRequest(val id: String)

@Serializable
data class NotesEventsResponse(val event: String, val note: Note)

@Serializable
data class NotesListResponse(val notes: List<Note>)

@Serializable
internal data class NotesReadRequest(val id: String)

@Serializable
data class NotesReadResponse(val note: Note)

@Serializable
internal data class NotesUpdateRequest(val note: NotesUpdate)

@Serializable
data class NotesUpdateResponse(val note: Note)

// Data (multiple use)

@Serializable
data class Note(
    val created: String,
    val id: String,
    val text: String,
    val title: String,
    val updated: String
)

@Serializable
data class NotesUpdate(
    val id: String,
    val text: String,
    val title: String
)
