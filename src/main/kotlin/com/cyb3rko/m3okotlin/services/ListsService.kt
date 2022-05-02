package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.WebSocket
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private const val SERVICE = "lists"

/**
 * **Make a list**
 *
 * Make lists for anything. Shopping, todos, mail, waitlists, absolutely
 * anything.
 *
 * @since 0.1.0
 */
object ListsService {

    /**
     * Create a new list
     * @since 0.1.0
     */
    suspend fun create(items: List<String>, name: String): ListsCreateResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Create")) {
            body = ListsCreateRequest(items, name)
        }
    }

    /**
     * Delete a list
     * @since 0.1.0
     */
    suspend fun delete(id: String): ListsDeleteResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = ListsDeleteRequest(id)
        }
    }

    /**
     * Subscribe to lists events
     * @since 0.1.0
     */
    fun events(
        id: String = "",
        action: (Exception?, ListsEventsResponse?) -> Unit
    ): WebSocket {
        val url = M3O.getUrl(SERVICE, "Events", true)
        val socket = WebSocket(
            url,
            Json.encodeToString(ListsEventsRequest(id))
        ) { e, response ->
            action(
                e,
                if (response != null) Json.decodeFromString(response) else null
            )
        }
        socket.connect()
        return socket
    }

    /**
     * List all the lists
     * @since 0.1.0
     */
    suspend fun list(): ListsListResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "List"))
    }

    /**
     * Read a list
     * @since 0.1.0
     */
    suspend fun read(id: String): ListsReadResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Read")) {
            body = ListsReadRequest(id)
        }
    }

    /**
     * Update a list
     * @since 0.1.0
     */
    suspend fun update(list: ListsUpdate): ListsUpdateResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Update")) {
            body = ListsUpdateRequest(list)
        }
    }
}
