package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "search"

/**
 * **Indexing and full text search**
 *
 * Store and search JSON records. The Search API provides indexing and full text
 * search. Search for a word or phrase in a particular field of a record.
 * Combine multiple with either AND or OR boolean operators to create complex
 * queries.
 *
 * @since 0.1.0
 */
object SearchService {

    /**
     * Create an index by name
     * @since 0.1.0
     */
    suspend fun createIndex(index: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "CreateIndex")) {
            body = SearchCreateIndexRequest(index)
        }
    }

    /**
     * Delete a record given its ID
     * @since 0.1.0
     */
    suspend fun delete(id: String, index: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = SearchDeleteRequest(id, index)
        }
    }

    /**
     * Delete an index by name
     * @since 0.1.0
     */
    suspend fun deleteIndex(index: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "DeleteIndex")) {
            body = SearchDeleteIndexRequest(index)
        }
    }

    /**
     * Index a record i.e. insert a document to search for.
     * @since 0.1.0
     */
    suspend fun index(
        data: JsonObject,
        index: String,
        id: String = ""
    ): SearchIndexResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Index")) {
            body = SearchIndexRequest(data, id, index)
        }
    }

    /**
     * Search for records in a given in index
     * @since 0.1.0
     */
    suspend fun search(index: String, query: String): SearchSearchResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Search")) {
            body = SearchSearchRequest(index, query)
        }
    }
}
