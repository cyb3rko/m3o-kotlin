package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

// Requests & Responses + Data (single use)

@Serializable
internal data class CommentsCreateRequest(val subject: String, val text: String)

@Serializable
data class CommentsCreateResponse(val comment: CommentsComment)

@Serializable
internal data class CommentsDeleteRequest(val id: String)

@Serializable
data class CommentsDeleteResponse(val comment: CommentsComment)

@Serializable
internal data class CommentsEventsRequest(val id: String)

@Serializable
data class CommentsEventsResponse(val comment: CommentsComment, val event: String)

@Serializable
data class CommentsListResponse(val comments: List<CommentsComment>)

@Serializable
internal data class CommentsReadRequest(val id: String)

@Serializable
data class CommentsReadResponse(val comment: CommentsComment)

@Serializable
internal data class CommentsUpdateRequest(val comment: CommentsUpdate)

@Serializable
data class CommentsUpdateResponse(val comment: CommentsComment)

// Data (multiple use; public request classes)

@Serializable
data class CommentsComment(
    val created: String,
    val id: String,
    val subject: String,
    val text: String,
    val updated: String
)

@Serializable
data class CommentsUpdate(
    val id: String,
    val subject: String,
    val text: String
)
