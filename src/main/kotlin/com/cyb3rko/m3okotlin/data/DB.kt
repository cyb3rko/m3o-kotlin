package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
internal data class DBCountRequest(val table: String)

@Serializable
data class DBCountResponse(val count: Int)

@Serializable
internal data class DBCreateRequest(
    val id: String,
    val record: JsonObject,
    val table: String
)

@Serializable
data class DBCreateResponse(val id: String)

@Serializable
internal data class DBDeleteRequest(val id: String, val table: String)

@Serializable
internal data class DBDropTableRequest(val table: String)

@Serializable
data class DBListTablesResponse(val tables: List<String>)

@Serializable
internal data class DBReadRequest(
    val id: String,
    val limit: Int,
    val offset: Int,
    val order: String,
    val orderBy: String,
    val query: String,
    val table: String
)

@Serializable
data class DBReadResponse(val records: List<JsonObject>)

@Serializable
internal data class DBRenameTableRequest(val from: String, val to: String)

@Serializable
internal data class DBTruncateRequest(val table: String)

@Serializable
internal data class DBUpdateRequest(
    val id: String,
    val record: JsonObject,
    val table: String
)
