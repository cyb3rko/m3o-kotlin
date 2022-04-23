package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class SunnahBooksRequest(
    val collection: String,
    val limit: Int,
    val page: Int
)

@Serializable
data class SunnahBooksResponse(
    val books: List<SunnahBook>,
    val collection: String,
    val limit: Int,
    val page: Int,
    val total: Int
) {

    @Serializable
    data class SunnahBook(
        @SerialName("arabic_name")
        val arabicName: String,
        val hadiths: Int,
        val id: Int,
        val name: String
    )
}

@Serializable
internal data class SunnahChaptersRequest(
    val book: Int,
    val collection: String,
    val limit: Int,
    val page: Int
)

@Serializable
data class SunnahChaptersResponse(
    val book: Int,
    val chapters: List<SunnahChapter>,
    val collection: String,
    val limit: Int,
    val page: Int,
    val total: Int
) {

    @Serializable
    data class SunnahChapter(
        @SerialName("arabic_title")
        val arabicTitle: String,
        val book: Int,
        val id: Int,
        val key: String,
        val title: String
    )
}

@Serializable
internal data class SunnahCollectionsRequest(
    val limit: Int,
    val page: Int
)

@Serializable
data class SunnahCollectionsResponse(val collections: List<SunnahCollection>) {

    @Serializable
    data class SunnahCollection(
        @SerialName("arabic_title")
        val arabicTitle: String,
        val hadiths: Int,
        val name: String,
        val summary: String,
        val title: String
    )
}

@Serializable
internal data class SunnahHadithsRequest(
    val book: Int,
    val collection: String,
    val limit: Int,
    val page: Int
)

@Serializable
data class SunnahHadithsResponse(
    val book: Int,
    val collection: String,
    val hadiths: List<SunnahHadith>,
    val limit: Int,
    val page: Int,
    val total: Int
) {

    @Serializable
    data class SunnahHadith(
        @SerialName("arabic_chapter_title")
        val arabicChapterTitle: String,
        @SerialName("arabic_text")
        val arabicText: String,
        val chapter: Int,
        @SerialName("chapter_key")
        val chapterKey: String,
        @SerialName("chapter_title")
        val chapterTitle: String,
        val id: Int,
        val text: String
    )
}
