package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class GIFsRequest(
    val lang: String,
    val limit: Int,
    val offset: Int,
    val query: String,
    val rating: String
)

@Serializable
data class GIFsResponse(
    val data: List<GIF>? = null,
    val pagination: GIFsPagination? = null
) {

    @Serializable
    data class GIF(
        @SerialName("embed_url")
        val embedUrl: String,
        val id: String,
        val images: GIFsImages,
        val rating: String,
        @SerialName("short_url")
        val shortUrl: String,
        val slug: String,
        val source: String,
        val title: String,
        val url: String
    ) {

        @Serializable
        data class GIFsImages(
            val downsized: GIFsImage,
            @SerialName("downsized_large")
            val downsizedLarge: GIFsImage,
            @SerialName("downsized_medium")
            val downsizedMedium: GIFsImage,
            @SerialName("downsized_small")
            val downsizedSmall: GIFsImage,
            @SerialName("downsized_still")
            val downsizedStill: GIFsImage,
            @SerialName("fixed_height")
            val fixedHeight: GIFsImage,
            @SerialName("fixed_height_downsampled")
            val fixedHeightDownsampled: GIFsImage,
            @SerialName("fixed_height_small")
            val fixedHeightSmall: GIFsImage,
            @SerialName("fixed_height_small_still")
            val fixedHeightSmallStill: GIFsImage,
            @SerialName("fixed_height_still")
            val fixedHeightStill: GIFsImage,
            @SerialName("fixed_width")
            val fixedWidth: GIFsImage,
            @SerialName("fixed_width_downsampled")
            val fixedWidthDownsampled: GIFsImage,
            @SerialName("fixed_width_small")
            val fixedWidthSmall: GIFsImage,
            @SerialName("fixed_width_small_still")
            val fixedWidthSmallStill: GIFsImage,
            @SerialName("fixed_width_still")
            val fixedWidthStill: GIFsImage,
            val looping: GIFsImage,
            val original: GIFsImage,
            @SerialName("original_still")
            val originalStill: GIFsImage,
            val preview: GIFsImage,
            @SerialName("preview_gif")
            val previewGIF: GIFsImage,
        ) {

            @Serializable
            data class GIFsImage(
                val height: Int,
                @SerialName("mp4_size")
                val mp4Size: Int,
                @SerialName("mp4_url")
                val mp4Url: String,
                val size: Int,
                val url: String,
                @SerialName("webp_size")
                val webpSize: Int,
                @SerialName("webp_url")
                val webpUrl: String,
                val width: Int
            )
        }
    }

    @Serializable
    data class GIFsPagination(
        val count: Int,
        val offset: Int,
        @SerialName("total_count")
        val totalCount: Int
    )
}
