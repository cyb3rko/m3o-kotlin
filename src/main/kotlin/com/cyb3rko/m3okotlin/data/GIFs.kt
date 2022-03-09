package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class GIFRequest(
    val lang: String,
    val limit: Int,
    val offset: Int,
    val query: String,
    val rating: String
)

@Serializable
data class GIFResponse(
    val data: List<GIF>,
    val pagination: Pagination
) {

    @Serializable
    data class GIF(
        @SerialName("embed_url")
        val embedUrl: String,
        val id: String,
        val images: GIFImages,
        val rating: String,
        @SerialName("short_url")
        val shortUrl: String,
        val slug: String,
        val source: String,
        val title: String,
        val url: String
    ) {

        @Serializable
        data class GIFImages(
            val downsized: GIFImage,
            @SerialName("downsized_large")
            val downsizedLarge: GIFImage,
            @SerialName("downsized_medium")
            val downsizedMedium: GIFImage,
            @SerialName("downsized_small")
            val downsizedSmall: GIFImage,
            @SerialName("downsized_still")
            val downsizedStill: GIFImage,
            @SerialName("fixed_height")
            val fixedHeight: GIFImage,
            @SerialName("fixed_height_downsampled")
            val fixedHeightDownsampled: GIFImage,
            @SerialName("fixed_height_small")
            val fixedHeightSmall: GIFImage,
            @SerialName("fixed_height_small_still")
            val fixedHeightSmallStill: GIFImage,
            @SerialName("fixed_height_still")
            val fixedHeightStill: GIFImage,
            @SerialName("fixed_width")
            val fixedWidth: GIFImage,
            @SerialName("fixed_width_downsampled")
            val fixedWidthDownsampled: GIFImage,
            @SerialName("fixed_width_small")
            val fixedWidthSmall: GIFImage,
            @SerialName("fixed_width_small_still")
            val fixedWidthSmallStill: GIFImage,
            @SerialName("fixed_width_still")
            val fixedWidthStill: GIFImage,
            val looping: GIFImage,
            val original: GIFImage,
            @SerialName("original_still")
            val originalStill: GIFImage,
            val preview: GIFImage,
            @SerialName("preview_gif")
            val previewGIF: GIFImage,
        ) {

            @Serializable
            data class GIFImage(
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
    data class Pagination(
        val count: Int,
        val offset: Int,
        @SerialName("total_count")
        val totalCount: Int
    )
}