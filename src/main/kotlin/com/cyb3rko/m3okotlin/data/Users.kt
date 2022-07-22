package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Requests & Responses + Data (single use)

@Serializable
internal data class UsersCreateRequest(
    val email: String,
    val id: String,
    val password: String,
    val profile: Map<String, String>,
    val username: String
)

@Serializable
data class UsersCreateResponse(val account: UsersAccount)

@Serializable
internal data class UsersDeleteRequest(val id: String)

@Serializable
internal data class UsersListRequest(val limit: Int, val offset: Int)

@Serializable
data class UsersListResponse(val users: List<UsersAccount>)

@Serializable
internal data class UsersLoginRequest(
    val email: String,
    val password: String,
    val username: String
)

@Serializable
data class UsersLoginResponse(val session: UsersSession)

@Serializable
internal data class UsersLogoutRequest(@SerialName("session_id") val sessionId: String)

@Serializable
internal data class UsersLogoutAllRequest(@SerialName("user_id") val userId: String)

@Serializable
internal data class UsersReadRequest(
    val email: String,
    val id: String,
    val username: String
)

@Serializable
data class UsersReadResponse(val account: UsersAccount)

@Serializable
internal data class UsersReadSessionRequest(@SerialName("session_id") val sessionId: String)

@Serializable
data class UsersReadSessionResponse(val session: UsersSession)

@Serializable
internal data class UsersResetPasswordRequest(
    val code: String,
    @SerialName("confirm_password")
    val confirmPassword: String,
    val email: String,
    @SerialName("new_password")
    val newPassword: String
)

@Serializable
internal data class UsersSendMagicLinkRequest(
    val address: String,
    val email: String,
    val endpoint: String,
    @SerialName("from_name")
    val fromName: String,
    val subject: String,
    @SerialName("text_content")
    val textContent: String
)

@Serializable
internal data class UsersSendPasswordResetEmailRequest(
    val email: String,
    val expiration: Int,
    @SerialName("from_name")
    val fromName: String,
    val subject: String,
    @SerialName("text_content")
    val textContent: String
)

@Serializable
internal data class UsersSendVerificationEmailRequest(
    val email: String,
    @SerialName("failure_redirect_url")
    val failureRedirectUrl: String,
    @SerialName("from_name")
    val fromName: String,
    @SerialName("redirect_url")
    val redirectUrl: String,
    val subject: String,
    @SerialName("text_content")
    val textContent: String
)

@Serializable
internal data class UsersUpdateRequest(
    val email: String,
    val id: String,
    val profile: Map<String, String>,
    val username: String
)

@Serializable
internal data class UsersUpdatePasswordRequest(
    @SerialName("confirm_password")
    val confirmPassword: String,
    @SerialName("new_password")
    val newPassword: String,
    @SerialName("old_password")
    val oldPassword: String,
    @SerialName("userId")
    val userId: String
)

@Serializable
internal data class UsersVerifyEmailRequest(val email: String, val token: String)

@Serializable
internal data class UsersVerifyTokenRequest(val token: String)

@Serializable
data class UsersVerifyTokenResponse(
    @SerialName("is_valid")
    val isValid: String,
    val message: String,
    val session: UsersSession
)

// Data (multiple use)

@Serializable
data class UsersAccount(
    val created: String,
    val email: String,
    val id: String,
    val profile: Map<String, String>,
    val updated: String,
    val username: String,
    @SerialName("verification_date")
    val verificationDate: String,
    val verified: Boolean
)

@Serializable
data class UsersSession(
    val created: String,
    val expires: String,
    val id: String,
    @SerialName("userId")
    val userId: String
)
