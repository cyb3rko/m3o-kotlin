package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "file"

object FilesService {

    suspend fun delete(path: String, project: String = "") {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
            body = FilesDeleteRequest(path, project)
        }
    }

    suspend fun list(path: String = "", project: String = ""): FilesListResponse {
        return ktorHttpClient.post(getUrl("file", "List")) {
            body = FilesListRequest(path, project)
        }
    }

    suspend fun read(path: String, project: String = ""): FilesReadResponse {
        return ktorHttpClient.post(getUrl("file", "Read")) {
            body = FilesReadRequest(path, project)
        }
    }

    suspend fun save(file: File, public: Boolean = false): FilesSaveResponse {
        return ktorHttpClient.post(getUrl("file", "Save")) {
            body = FilesSaveRequest(file, public)
        }
    }
}