package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "contact"

object ContactsService {

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

    suspend fun delete(id: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = ContactsDeleteRequest(id)
        }
    }

    suspend fun list(limit: Int = 30, offset: Int = 0): ContactsListResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "List")) {
            body = ContactsListRequest(limit, offset)
        }
    }

    suspend fun read(id: String): ContactsReadResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Read")) {
            body = ContactsReadRequest(id)
        }
    }

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