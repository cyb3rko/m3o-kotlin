package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Requests & Responses + Data (single use)

@Serializable
internal data class ContactsCreateRequest(
    val addresses: List<ContactsAddress>,
    val birthday: String,
    val emails: List<ContactsEmail>,
    val links: List<ContactsLink>,
    val name: String,
    val note: String,
    val phones: List<ContactsPhone>,
    @SerialName("social_medias")
    val socialMedias: List<ContactsSocialMedia>
)

@Serializable
data class ContactsCreateResponse(val contact: ContactsEntry)

@Serializable
internal data class ContactsDeleteRequest(val id: String)

@Serializable
internal data class ContactsListRequest(val limit: Int, val offset: Int)

@Serializable
data class ContactsListResponse(val contacts: List<ContactsEntry>)

@Serializable
internal data class ContactsReadRequest(val id: String)

@Serializable
data class ContactsReadResponse(val contact: ContactsEntry)

@Serializable
internal data class ContactsUpdateRequest(
    val addresses: List<ContactsAddress>,
    val birthday: String,
    val emails: List<ContactsEmail>,
    val id: String,
    val links: List<ContactsLink>,
    val name: String,
    val note: String,
    val phones: List<ContactsPhone>,
    @SerialName("social_medias")
    val socialMedias: List<ContactsSocialMedia>
)

@Serializable
data class ContactsUpdateResponse(val contact: ContactsEntry)

// Data (multiple use)

@Serializable
data class ContactsAddress(
    val label: String,
    val location: String
)

@Serializable
data class ContactsEmail(
    val address: String,
    val label: String
)

@Serializable
data class ContactsEntry(
    val addresses: List<ContactsAddress>,
    val birthday: String,
    @SerialName("created_at")
    val createdAt: String,
    val emails: List<ContactsEmail>,
    val id: String,
    val links: List<ContactsLink>,
    val name: String,
    val note: String,
    val phones: List<ContactsPhone>,
    @SerialName("social_medias")
    val socialMedias: List<ContactsSocialMedia>,
    @SerialName("updated_at")
    val updatedAt: String
)

@Serializable
data class ContactsLink(
    val label: String,
    val url: String
)

@Serializable
data class ContactsPhone(
    val label: String,
    val number: String
)

@Serializable
data class ContactsSocialMedia(
    val label: String,
    val username: String
)