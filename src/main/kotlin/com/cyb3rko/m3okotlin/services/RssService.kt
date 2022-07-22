package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import com.cyb3rko.m3okotlin.data.RssListResponse.RssFeed
import io.ktor.client.request.*

private const val SERVICE = "rss"

/**
 * **RSS feed crawler and reader**
 *
 * Provides a simple way to crawl and index RSS feeds making them accessible via
 * a simple unified API.
 *
 * @since 0.1.0
 */
object RssService {

    /**
     * Add a new RSS feed with a name, url, and category
     * @since 0.1.0
     */
    suspend fun add(
        name: String,
        url: String,
        category: String = ""
    ) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Add")) {
            body = RssAddRequest(category, name, url)
        }
    }

    /**
     * Get an RSS feed by name. If no name is given, all feeds are returned.
     * Default limit is 25 entries.
     * @since 0.1.0
     */
    suspend fun feed(
        name: String,
        limit: Int = 25,
        offset: Int = 0
    ): RssFeedResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Feed")) {
            body = RssFeedRequest(limit, name, offset)
        }
    }

    /**
     * List the saved RSS fields
     * @since 0.1.0
     */
    suspend fun list(): RssListResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "List"))
    }

    /**
     * Remove an RSS feed by name
     * @since 0.1.0
     */
    suspend fun remove(name: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Remove")) {
            body = RssRemoveRequest(name)
        }
    }

    suspend fun RssFeed.feed(limit: Int = 25, offset: Int = 0) = feed(
        this.name, limit, offset
    )

    suspend fun RssFeed.remove() = remove(this.name)
}
