package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import com.cyb3rko.m3okotlin.data.QuranChaptersResponse.QuranChapter
import io.ktor.client.request.*

private const val SERVICE = "quran"

/**
 * **The Holy Quran**
 *
 * The Holy Quran is the central religious text of Islam, believed by Muslims to
 * be a revelation from God (Allah). This service provides access to a
 * straightforward copy of that text including transliteration and translation.
 *
 * @since 0.1.0
 */
object QuranService {

    /**
     * List the Chapters (surahs) of the Quran
     * @since 0.1.0
     */
    suspend fun chapters(language: String = "en"): QuranChaptersResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Chapters")) {
            body = QuranChaptersRequest(language)
        }
    }

    /**
     * Search the Quran for any form of query or questions
     * @since 0.1.0
     */
    suspend fun search(
        query: String,
        language: String = "en",
        limit: Int = 0,
        page: Int = 1
    ): QuranSearchResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Search")) {
            body = QuranSearchRequest(language, limit, page, query)
        }
    }

    /**
     * Get a summary for a given chapter (surah)
     * @since 0.1.0
     */
    suspend fun summary(chapter: Int, language: String = "en"): QuranSummaryResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Summary")) {
            body = QuranSummaryRequest(chapter, language)
        }
    }

    /**
     * Lookup the verses (ayahs) for a chapter including translation,
     * interpretation and breakdown by individual words.
     * @since 0.1.0
     */
    suspend fun verses(
        chapter: Int,
//        interpret: Boolean = false,
        language: String = "en",
        limit: Int = 10,
        page: Int = 1,
        translate: Boolean = false,
        words: Boolean = false
    ): QuranVersesResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Verses")) {
            body = QuranVersesRequest(chapter, language, limit, page, translate, words)
        }
    }

    suspend fun QuranChapter.summary() = summary(this.id)

    suspend fun QuranChapter.verses(
        language: String = "en",
        limit: Int = 10,
        page: Int = 1,
        translate: Boolean = false,
        words: Boolean = false
    ) = verses(this.id, language, limit, page, translate, words)
}
