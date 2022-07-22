package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class GifsRequest(
    val lang: String,
    val limit: Int,
    val offset: Int,
    val query: String,
    val rating: String
)

@Serializable
data class GifsResponse(
    val data: List<Gif>? = null,
    val pagination: GifsPagination? = null
) {

    @Serializable
    data class Gif(
        @SerialName("embed_url")
        val embedUrl: String,
        val id: String,
        val images: GifsImages,
        val rating: String,
        @SerialName("short_url")
        val shortUrl: String,
        val slug: String,
        val source: String,
        val title: String,
        val url: String
    ) {

        @Serializable
        data class GifsImages(
            val downsized: GifsImage,
            @SerialName("downsized_large")
            val downsizedLarge: GifsImage,
            @SerialName("downsized_medium")
            val downsizedMedium: GifsImage,
            @SerialName("downsized_small")
            val downsizedSmall: GifsImage,
            @SerialName("downsized_still")
            val downsizedStill: GifsImage,
            @SerialName("fixed_height")
            val fixedHeight: GifsImage,
            @SerialName("fixed_height_downsampled")
            val fixedHeightDownsampled: GifsImage,
            @SerialName("fixed_height_small")
            val fixedHeightSmall: GifsImage,
            @SerialName("fixed_height_small_still")
            val fixedHeightSmallStill: GifsImage,
            @SerialName("fixed_height_still")
            val fixedHeightStill: GifsImage,
            @SerialName("fixed_width")
            val fixedWidth: GifsImage,
            @SerialName("fixed_width_downsampled")
            val fixedWidthDownsampled: GifsImage,
            @SerialName("fixed_width_small")
            val fixedWidthSmall: GifsImage,
            @SerialName("fixed_width_small_still")
            val fixedWidthSmallStill: GifsImage,
            @SerialName("fixed_width_still")
            val fixedWidthStill: GifsImage,
            val looping: GifsImage,
            val original: GifsImage,
            @SerialName("original_still")
            val originalStill: GifsImage,
            val preview: GifsImage,
            @SerialName("preview_gif")
            val previewGif: GifsImage,
        ) {

            @Serializable
            data class GifsImage(
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
    data class GifsPagination(
        val count: Int,
        val offset: Int,
        @SerialName("total_count")
        val totalCount: Int
    )
}
