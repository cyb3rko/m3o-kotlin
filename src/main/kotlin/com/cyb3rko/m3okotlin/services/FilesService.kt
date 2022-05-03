package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "file"

/**
 * **Store, list, and retrieve text files**
 *
 * Save, list, and retrieve text files. Files can have a path in the same way
 * they would on your computer e.g. /documents/text-files/file.txt. Files can
 * optionally be grouped in to projects.
 *
 * @since 0.1.0
 */
object FilesService {

    /**
     * Delete a file by project name/path
     * @since 0.1.0
     */
    suspend fun delete(path: String, project: String = "") {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
            body = FilesDeleteRequest(path, project)
        }
    }

    /**
     * List files by their project and optionally a path.
     * @since 0.1.0
     */
    suspend fun list(path: String = "", project: String = ""): FilesListResponse {
        return ktorHttpClient.post(getUrl("file", "List")) {
            body = FilesListRequest(path, project)
        }
    }

    /**
     * Read a file by path
     * @since 0.1.0
     */
    suspend fun read(path: String, project: String = ""): FilesReadResponse {
        return ktorHttpClient.post(getUrl("file", "Read")) {
            body = FilesReadRequest(path, project)
        }
    }

    /**
     * Save a file
     * @since 0.1.0
     */
    suspend fun save(file: File, public: Boolean = false): FilesSaveResponse {
        return ktorHttpClient.post(getUrl("file", "Save")) {
            body = FilesSaveRequest(file, public)
        }
    }

    suspend fun File.delete() = delete(this.path, this.project)

    suspend fun File.read() = read(this.path, this.project)
}
