package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class FilesDeleteRequest(val path: String, val project: String)

@Serializable
internal data class FilesListRequest(val path: String, val project: String)

@Serializable
data class FilesListResponse(val files: List<File>)

@Serializable
internal data class FilesReadRequest(val path: String, val project: String)

@Serializable
data class FilesReadResponse(val file: File)

@Serializable
internal data class FilesSaveRequest(val file: File, val public: Boolean)

@Serializable
data class FilesSaveResponse(val url: String)

@Serializable
data class File(
    val content: String,
    val path: String,
    val project: String,
    val metadata: Map<String, String> = emptyMap(),
    val created: String = "",
    val updated: String = ""
)