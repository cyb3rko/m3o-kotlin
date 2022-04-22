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

object SpaceService {

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

    suspend fun delete(name: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = SpaceDeleteRequest(name)
        }
    }

    suspend fun download(name: String): SpaceDownloadResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Download")) {
            body = SpaceDownloadRequest(name)
        }
    }

    suspend fun head(name: String): SpaceHeadResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Head")) {
            body = SpaceHeadRequest(name)
        }
    }

    suspend fun list(prefix: String = ""): SpaceListResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "List")) {
            body = SpaceListRequest(prefix)
        }
    }

    suspend fun read(name: String): SpaceReadResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Read")) {
            body = SpaceReadRequest(name)
        }
    }

    suspend fun update(
        name: String,
        objectBase64: String = "",
        objectFile: File? = null,
        visibility: String = "private"
    ): SpaceCreateResponse {
        val endpointURL = M3O.getUrl(SERVICE, "Update")

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

    suspend fun upload(name: String, visibility: String = "private"): SpaceUploadResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Upload")) {
            body = SpaceUploadRequest(name, visibility)
        }
    }
}
