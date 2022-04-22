package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

// Requests & Responses + Data (single use)

@Serializable
internal data class ListsCreateRequest(val items: List<String>, val name: String)

@Serializable
data class ListsCreateResponse(val list: ListsList)

@Serializable
internal data class ListsDeleteRequest(val id: String)

@Serializable
data class ListsDeleteResponse(val list: ListsList)

@Serializable
internal data class ListsEventsRequest(val id: String)

@Serializable
data class ListsEventsResponse(val event: String, val list: ListsList)

@Serializable
data class ListsListResponse(val lists: List<ListsList>)

@Serializable
internal data class ListsReadRequest(val id: String)

@Serializable
data class ListsReadResponse(val list: ListsList)

@Serializable
internal data class ListsUpdateRequest(val list: ListsUpdate)

@Serializable
data class ListsUpdateResponse(val list: ListsList)

// Data (multiple use; public request classes)

@Serializable
data class ListsList(
    val created: String,
    val id: String,
    val items: List<String>,
    val name: String,
    val updated: String
)

@Serializable
data class ListsUpdate(
    val id: String,
    val items: List<String>,
    val name: String
)
