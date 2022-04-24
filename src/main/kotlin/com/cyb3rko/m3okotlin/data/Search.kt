package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

// Requests & Responses + Data (single use)

@Serializable
internal data class SearchCreateIndexRequest(val index: String)

@Serializable
internal data class SearchDeleteRequest(val id: String, val index: String)

@Serializable
internal data class SearchDeleteIndexRequest(val index: String)

@Serializable
internal data class SearchIndexRequest(
    val data: JsonObject,
    val id: String,
    val index: String
)

@Serializable
data class SearchIndexResponse(val record: SearchRecord)

@Serializable
internal data class SearchSearchRequest(val index: String, val query: String)

@Serializable
data class SearchSearchResponse(val records: List<SearchRecord>)

// Data (multiple use)

@Serializable
data class SearchRecord(
    val data: JsonObject,
    val id: String
)
