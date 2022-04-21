package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Requests & Responses + Data (single use)

@Serializable
internal data class QuranChaptersRequest(val language: String)

@Serializable
data class QuranChaptersResponse(val chapters: List<QuranChapter>) {

    @Serializable
    data class QuranChapter(
        @SerialName("arabic_name")
        val arabicName: String,
        @SerialName("complex_name")
        val complexName: String,
        val id: Int,
        val name: String,
        val pages: List<Int>,
        @SerialName("prefix_bismillah")
        val prefixBismillah: Boolean,
        @SerialName("revelation_order")
        val revelationOrder: Int,
        @SerialName("revelation_place")
        val revelationPlace: String,
        @SerialName("translated_name")
        val translatedName: String,
        val verses: Int
    )
}

@Serializable
internal data class QuranSearchRequest(
    val language: String,
    val limit: Int,
    val page: Int,
    val query: String
)

@Serializable
data class QuranSearchResponse(
    val page: Int,
    val query: String,
    val results: List<QuranSearchResult>,
    @SerialName("total_pages")
    val totalPages: Int,
    @SerialName("total_results")
    val totalResults: Int
) {

    @Serializable
    data class QuranSearchResult(
        val text: String,
        @SerialName("verse_id")
        val verseID: Int,
        @SerialName("verse_key")
        val verseKey: String,
        val translations: List<QuranVerseTranslation>
    )
}

@Serializable
internal data class QuranSummaryRequest(val chapter: Int, val language: String)

@Serializable
data class QuranSummaryResponse(
    val chapter: Int,
    val source: String,
    val summary: String,
    val text: String
)

@Serializable
internal data class QuranVersesRequest(
    val chapter: Int,
//    val interpret: Boolean,
    val language: String,
    val limit: Int,
    val page: Int,
    val translate: Boolean,
    val words: Boolean
)

@Serializable
data class QuranVersesResponse(
    val chapter: Int,
    val page: Int,
    @SerialName("total_pages")
    val totalPages: Int,
    val verses: List<QuranVerse>
) {

    @Serializable
    data class QuranVerse(
        val id: Int,
//        val interpretations: List<QuranVerseInterpretation>,
        val key: String,
        val number: Int,
        val page: Int,
        val text: String,
        @SerialName("translated_text")
        val translatedText: String,
        val translations: List<QuranVerseTranslation>,
        val transliteration: String,
        val words: List<QuranVerseWord>
    ) {

        @Serializable
        data class QuranVerseWord(
            @SerialName("char_type")
            val charType: String,
            val code: String,
            val id: Int,
            val line: Int,
            val page: Int,
            val position: Int,
            val text: String,
            val translation: String,
            val transliteration: String
        )
    }
}

// Data (multiple use)

@Serializable
data class QuranVerseTranslation(
    val id: Int,
    val source: String,
    val text: String
)
