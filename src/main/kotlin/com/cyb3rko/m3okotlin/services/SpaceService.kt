package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.InvalidParameterException
import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.http.*
import io.ktor.utils.io.core.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File

private const val SERVICE = "space"

/**
 * **Infinite cloud storage**
 *
 * Space for simple object storage. Put anything in the cloud forever. Objects
 * can be public (readable by all via a public URL) or private.
 *
 * @since 0.1.0
 */
object SpaceService {

    /**
     * Create an object. Returns error if object with this name already exists.
     * Max object size of 10MB, see Upload endpoint for larger objects. If you
     * want to update an existing object use the `Update` endpoint
     * @since 0.1.0
     */
    suspend fun create(
        name: String,
        objectBase64: String = "",
        objectFile: File? = null,
        visibility: String = "private"
    ): SpaceCreateResponse {
        val endpointURL = M3O.getUrl(SERVICE, "Create")

        if (objectBase64 != "") {
            return M3O.ktorHttpClient.post(endpointURL) {
                body = SpaceCreateRequest(name, objectBase64, visibility)
            }
        } else if (objectFile != null) {
            val response = M3O.getKtorHttpMultipartClient().post<String>(endpointURL) {
                body = MultiPartFormDataContent(
                    formData {
                        appendInput(
                            "object",
                            Headers.build { append(HttpHeaders.ContentDisposition, "filename=${objectFile.name}") },
                            objectFile.length()
                        ) {
                            buildPacket { writeFully(objectFile.readBytes()) }
                        }
                        append(FormPart("name", name))
                        append(FormPart("visibility", visibility))
                    }
                )
            }
            return Json.decodeFromString(response)
        } else throw InvalidParameterException("No object found, \"objectBase64\" and \"objectFile\" are empty.")
    }

    /**
     * Delete an object from space
     * @since 0.1.0
     */
    suspend fun delete(name: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = SpaceDeleteRequest(name)
        }
    }

    /**
     * Download an object via a presigned url
     * @since 0.1.0
     */
    suspend fun download(name: String): SpaceDownloadResponse {
        return M3O.getKtorHttpRedirectClient().post(M3O.getUrl(SERVICE, "Download")) {
            body = SpaceDownloadRequest(name)
        }
    }

    /**
     * Retrieve meta information about an object
     * @since 0.1.0
     */
    suspend fun head(name: String): SpaceHeadResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Head")) {
            body = SpaceHeadRequest(name)
        }
    }

    /**
     * List the objects in space
     * @since 0.1.0
     */
    suspend fun list(prefix: String = ""): SpaceListResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "List")) {
            body = SpaceListRequest(prefix)
        }
    }

    /**
     * Read an object in space
     * @since 0.1.0
     */
    suspend fun read(name: String): SpaceReadResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Read")) {
            body = SpaceReadRequest(name)
        }
    }

    /**
     * Update an object. If an object with this name does not exist, creates a
     * new one.
     * @since 0.1.0
     */
    suspend fun update(
        name: String,
        objectBase64: String = "",
        objectFile: File? = null,
        visibility: String = "private"
    ): SpaceUpdateResponse {
        val endpointURL = M3O.getUrl(SERVICE, "Update")

        if (objectBase64 != "") {
            return M3O.ktorHttpClient.post(endpointURL) {
                body = SpaceUpdateRequest(name, objectBase64, visibility)
            }
        } else if (objectFile != null) {
            val response = M3O.getKtorHttpMultipartClient().post<String>(endpointURL) {
                body = MultiPartFormDataContent(
                    formData {
                        appendInput(
                            "object",
                            Headers.build { append(HttpHeaders.ContentDisposition, "filename=${objectFile.name}") },
                            objectFile.length()
                        ) {
                            buildPacket { writeFully(objectFile.readBytes()) }
                        }
                        append(FormPart("name", name))
                        append(FormPart("visibility", visibility))
                    }
                )
            }
            return Json.decodeFromString(response)
        } else throw InvalidParameterException("No object found, \"objectBase64\" and \"objectFile\" are empty.")
    }

    /**
     * Upload a large object (> 10MB). Returns a time limited presigned URL to
     * be used for uploading the object
     * @since 0.1.0
     */
    suspend fun upload(name: String, visibility: String = "private"): SpaceUploadResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Upload")) {
            body = SpaceUploadRequest(name, visibility)
        }
    }

    suspend fun SpaceObject.delete() = delete(this.name)

    suspend fun SpaceObject.download() = download(this.name)

    suspend fun SpaceObject.update(
        objectBase64: String = "",
        objectFile: File? = null,
        visibility: String = "private"
    ) = update(this.name, objectBase64, objectFile, visibility)

    suspend fun SpaceObject.upload(visibility: String = "private") = upload(this.name, visibility)

    suspend fun SpaceObjectMetaData.delete() = delete(this.name)

    suspend fun SpaceObjectMetaData.download() = download(this.name)

    suspend fun SpaceObjectMetaData.read() = read(this.name)

    suspend fun SpaceObjectMetaData.update(
        objectBase64: String = "",
        objectFile: File? = null,
        visibility: String = "private"
    ) = update(this.name, objectBase64, objectFile, visibility)

    suspend fun SpaceObjectMetaData.upload(visibility: String = "private") = upload(this.name, visibility)
}
