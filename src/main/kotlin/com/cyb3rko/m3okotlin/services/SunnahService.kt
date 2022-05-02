package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "sunnah"

/**
 * **Traditions and practices of the Islamic prophet, Muhammad (pbuh)**
 *
 * Sunnah are the traditions and practices of the Islamic prophet, Muhammad,
 * that constitute a model for Muslims to follow. According to classical Islamic
 * theories, the sunnah are documented by hadith (the verbally transmitted
 * record of the teachings, deeds and sayings, silent permissions or
 * disapprovals of Muhammad), and along with the Quran (the book of Islam), are
 * the divine revelation (Wahy) delivered through Muhammad that make up the
 * primary sources of Islamic law and belief/theology.
 *
 * @since 0.1.0
 */
object SunnahService {

    /**
     * Get a list of books from within a collection. A book can contain many
     * chapters each with its own hadiths.
     * @since 0.1.0
     */
    suspend fun books(
        collection: String,
        limit: Int = 0,
        page: Int = 0
    ): SunnahBooksResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Books")) {
            body = SunnahBooksRequest(collection, limit, page)
        }
    }

    /**
     * Get all the chapters of a given book within a collection.
     * @since 0.1.0
     */
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

    /**
     * Get a list of available collections. A collection is a compilation of
     * hadiths collected and written by an author.
     * @since 0.1.0
     */
    suspend fun collections(limit: Int = 0, page: Int = 0): SunnahCollectionsResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Collections")) {
            body = SunnahCollectionsRequest(limit, page)
        }
    }

    /**
     * Hadiths returns a list of hadiths and their corresponding text for a
     * given book within a collection.
     * @since 0.1.0
     */
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
