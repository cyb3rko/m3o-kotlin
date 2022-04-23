package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "sunnah"

object SunnahService {

    suspend fun books(
        collection: String,
        limit: Int = 0,
        page: Int = 0
    ): SunnahBooksResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Books")) {
            body = SunnahBooksRequest(collection, limit, page)
        }
    }

    suspend fun chapters(
        book: Int,
        collection: String,
        limit: Int = 0,
        page: Int = 0
    ): SunnahChaptersResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Chapters")) {
            body = SunnahChaptersRequest(book, collection, limit, page)
        }
    }

    suspend fun collections(limit: Int = 0, page: Int = 0): SunnahCollectionsResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Collections")) {
            body = SunnahCollectionsRequest(limit, page)
        }
    }

    suspend fun hadiths(
        book: Int,
        collection: String,
        limit: Int = 0,
        page: Int = 0
    ): SunnahHadithsResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Hadiths")) {
            body = SunnahHadithsRequest(book, collection, limit, page)
        }
    }
}
