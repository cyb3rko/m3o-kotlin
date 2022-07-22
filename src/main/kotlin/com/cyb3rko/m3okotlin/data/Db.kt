package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
internal data class DbCountRequest(val table: String)

@Serializable
data class DbCountResponse(val count: Int)

@Serializable
internal data class DbCreateRequest(
    val id: String,
    val record: JsonObject,
    val table: String
)

@Serializable
data class DbCreateResponse(val id: String)

@Serializable
internal data class DbDeleteRequest(val id: String, val table: String)

@Serializable
internal data class DbDropTableRequest(val table: String)

@Serializable
data class DbListTablesResponse(val tables: List<String>)

@Serializable
internal data class DbReadRequest(
    val id: String,
    val limit: Int,
    val offset: Int,
    val order: String,
    val orderBy: String,
    val query: String,
    val table: String
)

@Serializable
data class DbReadResponse(val records: List<JsonObject>)

@Serializable
internal data class DbRenameTableRequest(val from: String, val to: String)

@Serializable
internal data class DbTruncateRequest(val table: String)

@Serializable
internal data class DbUpdateRequest(
    val id: String,
    val record: JsonObject,
    val table: String
)
