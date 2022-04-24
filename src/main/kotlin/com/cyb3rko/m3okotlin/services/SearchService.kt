package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "search"

object SearchService {

    suspend fun createIndex(index: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "CreateIndex")) {
            body = SearchCreateIndexRequest(index)
        }
    }

    suspend fun delete(id: String, index: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = SearchDeleteRequest(id, index)
        }
    }

    suspend fun deleteIndex(index: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "DeleteIndex")) {
            body = SearchDeleteIndexRequest(index)
        }
    }

    suspend fun index(
        data: JsonObject,
        index: String,
        id: String = ""
    ): SearchIndexResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Index")) {
            body = SearchIndexRequest(data, id, index)
        }
    }

    suspend fun search(index: String, query: String): SearchSearchResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Search")) {
            body = SearchSearchRequest(index, query)
        }
    }
}
