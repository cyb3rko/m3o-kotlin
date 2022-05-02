package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "contact"

/**
 * **Store your contacts**
 *
 * This is the Contact service
 *
 * @since 0.1.0
 */
object ContactsService {

    /**
     * Create a contact
     * @since 0.1.0
     */
    suspend fun create(
        name: String,
        addresses: List<ContactsAddress> = listOf(),
        birthday: String = "",
        emails: List<ContactsEmail> = listOf(),
        links: List<ContactsLink> = listOf(),
        note: String = "",
        phones: List<ContactsPhone> = listOf(),
        socialMedias: List<ContactsSocialMedia> = listOf()
    ): ContactsCreateResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Create")) {
            body = ContactsCreateRequest(addresses, birthday, emails, links, name, note, phones, socialMedias)
        }
    }

    /**
     * Delete a contact
     * @since 0.1.0
     */
    suspend fun delete(id: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = ContactsDeleteRequest(id)
        }
    }

    /**
     * List contacts
     * @since 0.1.0
     */
    suspend fun list(limit: Int = 30, offset: Int = 0): ContactsListResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "List")) {
            body = ContactsListRequest(limit, offset)
        }
    }

    /**
     * Read contact details
     * @since 0.1.0
     */
    suspend fun read(id: String): ContactsReadResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Read")) {
            body = ContactsReadRequest(id)
        }
    }

    /**
     * Update a contact
     * @since 0.1.0
     */
    suspend fun update(
        id: String,
        name: String,
        addresses: List<ContactsAddress> = listOf(),
        birthday: String = "",
        emails: List<ContactsEmail> = listOf(),
        links: List<ContactsLink> = listOf(),
        note: String = "",
        phones: List<ContactsPhone> = listOf(),
        socialMedias: List<ContactsSocialMedia> = listOf()
    ): ContactsUpdateResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Update")) {
            body = ContactsUpdateRequest(addresses, birthday, emails, id, links, name, note, phones, socialMedias)
        }
    }
}
