package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "quran"

object QuranService {

    suspend fun chapters(language: String = "en"): QuranChaptersResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Chapters")) {
            body = QuranChaptersRequest(language)
        }
    }

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

    suspend fun summary(chapter: Int, language: String = "en"): QuranSummaryResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Summary")) {
            body = QuranSummaryRequest(chapter, language)
        }
    }

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
}
