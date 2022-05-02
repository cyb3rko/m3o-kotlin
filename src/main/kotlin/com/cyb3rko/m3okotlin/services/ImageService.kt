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

/**
 * **Upload, resize, and convert images**
 *
 * The image service provides upload, resize, and image conversion. It provides
 * a CDN for uploaded images and a simple API.
 *
 * @since 0.1.0
 */
object ImageService {

    /**
     * Convert an image from one format (jpeg, png etc.) to an other either on
     * the fly (from base64 to base64), or by uploading the conversion result.
     * To use the file parameter you need to send the request as a
     * multipart/form-data rather than the usual application/json with each
     * parameter as a form field.
     * @since 0.1.0
     */
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

    /**
     * Delete an image previously uploaded.
     * @since 0.1.0
     */
    suspend fun delete(url: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = ImageDeleteRequest(url)
        }
    }

    /**
     * Resize an image on the fly without storing it (by sending and receiving a
     * base64 encoded image), or resize and upload depending on parameters. If
     * one of width or height is 0, the image aspect ratio is preserved.
     * Optional cropping. To use the file parameter you need to send the request
     * as a multipart/form-data rather than the usual application/json with each
     * parameter as a form field.
     * @since 0.1.0
     */
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

    /**
     * Upload an image by either sending a base64 encoded image to this endpoint
     * or a URL. To resize an image before uploading, see the Resize endpoint.
     * To use the file parameter you need to send the request as a
     * multipart/form-data rather than the usual application/json with each
     * parameter as a form field.
     * @since 0.1.0
     */
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
