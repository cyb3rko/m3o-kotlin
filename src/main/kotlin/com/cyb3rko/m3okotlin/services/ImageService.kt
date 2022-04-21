package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.InvalidParameterException
import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.http.*
import io.ktor.utils.io.core.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

private const val SERVICE = "image"

object ImageService {

    suspend fun convert(
        name: String,
        base64: String = "",
        file: File? = null,
        outputURL: Boolean = false,
        url: String = ""
    ): ImageConvertResponse {
        val endpointURL = M3O.getUrl(SERVICE, "Convert")

        if (base64 != "" || url != "") {
            return M3O.ktorHttpClient.post(endpointURL) {
                body = ImageConvertRequest(base64, "", name, outputURL, url)
            }
        } else if (file != null) {
            val response = M3O.getKtorHttpMultipartClient().post<String>(endpointURL) {
                body = MultiPartFormDataContent(
                    formData {
                        appendInput(
                            "file",
                            Headers.build { append(HttpHeaders.ContentDisposition, "filename=${file.name}") },
                            file.length()
                        ) {
                            buildPacket { writeFully(file.readBytes()) }
                        }
                        append(FormPart("name", name))
                        append(FormPart("outputURL", outputURL))
                    }
                )
            }
            return Json.decodeFromString(response)
        } else throw InvalidParameterException("No image found, \"base64\", \"file\" and \"url\" are empty.")
    }

    suspend fun delete(url: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = ImageDeleteRequest(url)
        }
    }

    suspend fun resize(
        name: String,
        height: Int,
        width: Int,
        base64: String = "",
        cropOptions: ImageResizeRequest.ImageCropOptions? = null,
        file: File? = null,
        outputURL: Boolean = false,
        url: String = ""
    ): ImageResizeResponse {
        val endpointURL = M3O.getUrl(SERVICE, "Resize")

        if (base64 != "" || url != "") {
            return M3O.ktorHttpClient.post(endpointURL) {
                body = ImageResizeRequest(base64, cropOptions, "", height, name, outputURL, url, width)
            }
        } else if (file != null) {
            val response = M3O.getKtorHttpMultipartClient().post<String>(endpointURL) {
                body = MultiPartFormDataContent(
                    formData {
                        appendInput(
                            "file",
                            Headers.build { append(HttpHeaders.ContentDisposition, "filename=${file.name}") },
                            file.length()
                        ) {
                            buildPacket { writeFully(file.readBytes()) }
                        }
                        if (cropOptions != null) {
                            append(FormPart("cropOptions", Json.encodeToString(cropOptions)))
                        }
                        append(FormPart("height", height))
                        append(FormPart("name", name))
                        append(FormPart("outputURL", outputURL))
                        append(FormPart("width", width))
                    }
                )
            }
            return Json.decodeFromString(response)
        } else throw InvalidParameterException("No image found, \"base64\", \"file\" and \"url\" are empty.")
    }

    suspend fun upload(
        name: String,
        base64: String = "",
        file: File? = null,
        url: String = ""
    ): ImageUploadResponse {
        val endpointURL = M3O.getUrl(SERVICE, "Upload")

        if (base64 != "" || url != "") {
            return M3O.ktorHttpClient.post(endpointURL) {
                body = ImageUploadRequest(base64, "", name, url)
            }
        } else if (file != null) {
            val response = M3O.getKtorHttpMultipartClient().post<String>(endpointURL) {
                body = MultiPartFormDataContent(
                    formData {
                        appendInput(
                            "file",
                            Headers.build { append(HttpHeaders.ContentDisposition, "filename=${file.name}") },
                            file.length()
                        ) {
                            buildPacket { writeFully(file.readBytes()) }
                        }
                        append(FormPart("name", name))
                    }
                )
            }
            return Json.decodeFromString(response)
        } else throw InvalidParameterException("No image found, \"base64\", \"file\" and \"url\" are empty.")
    }
}
