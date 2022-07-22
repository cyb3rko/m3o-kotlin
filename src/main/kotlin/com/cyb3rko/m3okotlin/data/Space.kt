package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

// Requests & Responses + Data (single use)

@Serializable
internal data class SpaceCreateRequest(
    val name: String,
    val `object`: String,
    val visibility: String
)

@Serializable
data class SpaceCreateResponse(val url: String)

@Serializable
internal data class SpaceDeleteRequest(val name: String)

@Serializable
internal data class SpaceDownloadRequest(val name: String)

@Serializable
data class SpaceDownloadResponse(val url: String)

@Serializable
internal data class SpaceHeadRequest(val name: String)

@Serializable
data class SpaceHeadResponse(val `object`: SpaceObjectMetaData)

@Serializable
internal data class SpaceListRequest(val prefix: String)

@Serializable
data class SpaceListResponse(val objects: List<SpaceObjectMetaData>)

@Serializable
internal data class SpaceReadRequest(val name: String)

@Serializable
data class SpaceReadResponse(val `object`: SpaceObject)

@Serializable
internal data class SpaceUpdateRequest(
    val name: String,
    val `object`: String,
    val visibility: String
)

@Serializable
data class SpaceUpdateResponse(val url: String)

@Serializable
internal data class SpaceUploadRequest(val name: String, val visibility: String)

@Serializable
data class SpaceUploadResponse(val url: String)

// Data (multiple use)

@Serializable
data class SpaceObject(
    val created: String,
    val data: String,
    val modified: String,
    val name: String,
    val url: String,
    val visibility: String
)

@Serializable
data class SpaceObjectMetaData(
    val created: String,
    val modified: String,
    val name: String,
    val url: String,
    val visibility: String
)
