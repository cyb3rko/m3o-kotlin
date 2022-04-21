package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class ImageConvertRequest(
    val base64: String,
    val file: String,
    val name: String,
    val outputURL: Boolean,
    val url: String
)

@Serializable
data class ImageConvertResponse(
    val base64: String,
    val url: String
)

@Serializable
internal data class ImageDeleteRequest(val url: String)

@Serializable
data class ImageResizeRequest(
    val base64: String,
    val cropOptions: ImageCropOptions? = null,
    val file: String,
    val height: Int,
    val name: String,
    val outputURL: Boolean,
    val url: String,
    val width: Int
) {

    @Serializable
    data class ImageCropOptions(
        val height: Int,
        val width: Int,
        val anchor: String = "center",
    )
}

@Serializable
data class ImageResizeResponse(
    val base64: String,
    val url: String
)

@Serializable
internal data class ImageUploadRequest(
    val base64: String,
    val file: String,
    val name: String,
    val url: String
)

@Serializable
data class ImageUploadResponse(val url: String)
