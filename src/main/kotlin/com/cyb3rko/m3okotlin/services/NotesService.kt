package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.WebSocket
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private const val SERVICE = "notes"

/**
 * **Store and retrieve notes**
 *
 * The notes service lets you keep track of notes as first class objects.
 * Subscribe to changes and perform fast retrieval of all your notes.
 *
 * @since 0.1.0
 */
object NotesService {

    /**
     * Create a new note
     * @since 0.1.0
     */
    suspend fun create(text: String, title: String): NotesCreateResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Create")) {
            body = NotesCreateRequest(text, title)
        }
    }

    /**
     * Delete a note
     * @since 0.1.0
     */
    suspend fun delete(id: String): NotesDeleteResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = NotesDeleteRequest(id)
        }
    }

    /**
     * Subscribe to notes events
     * @since 0.1.0
     */
    fun events(
        id: String = "",
        action: (Exception?, NotesEventsResponse?) -> Unit
    ): WebSocket {
        val url = M3O.getUrl(SERVICE, "Events", true)
        val socket = WebSocket(
            url,
            Json.encodeToString(NotesEventsRequest(id))
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
     * List all the notes
     * @since 0.1.0
     */
    suspend fun list(): NotesListResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "List"))
    }

    /**
     * Read a note
     * @since 0.1.0
     */
    suspend fun read(id: String): NotesReadResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Read")) {
            body = NotesReadRequest(id)
        }
    }

    /**
     * Update a note
     * @since 0.1.0
     */
    suspend fun update(note: NotesUpdate): NotesUpdateResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Update")) {
            body = NotesUpdateRequest(note)
        }
    }

    suspend fun Note.delete() = delete(this.id)

    fun Note.events(action: (Exception?, NotesEventsResponse?) -> Unit) = events(
        this.id,
        action
    )

    suspend fun Note.read() = read(this.id)

    suspend fun Note.update(text: String, title: String) = update(NotesUpdate(this.id, text, title))
}
