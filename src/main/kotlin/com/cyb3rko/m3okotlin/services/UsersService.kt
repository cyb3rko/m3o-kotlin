package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "user"

object UsersService {

    suspend fun create(
        email: String,
        password: String,
        username: String,
        id: String = "",
        profile: Map<String, String> = emptyMap()
    ): UsersCreateResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Create")) {
            body = UsersCreateRequest(email, id, password, profile, username)
        }
    }

    suspend fun delete(id: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = UsersDeleteRequest(id)
        }
    }

    suspend fun list(limit: Int = 25, offset: Int = 0): UsersListResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "List")) {
            body = UsersListRequest(limit, offset)
        }
    }

    suspend fun login(
        password: String,
        email: String = "",
        username: String = "",
    ): UsersLoginResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Login")) {
            body = UsersLoginRequest(email, password, username)
        }
    }

    suspend fun logout(sessionID: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Logout")) {
            body = UsersLogoutRequest(sessionID)
        }
    }

    suspend fun logoutAll(userID: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "LogoutAll")) {
            body = UsersLogoutAllRequest(userID)
        }
    }

    suspend fun read(
        email: String = "",
        id: String = "",
        username: String = "",
    ): UsersReadResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Read")) {
            body = UsersReadRequest(email, id, username)
        }
    }

    suspend fun readSession(sessionID: String): UsersReadSessionResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "ReadSession")) {
            body = UsersReadSessionRequest(sessionID)
        }
    }

    suspend fun resetPassword(
        code: String,
        confirmPassword: String,
        email: String,
        newPassword: String
    ) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "ResetPassword")) {
            body = UsersResetPasswordRequest(code, confirmPassword, email, newPassword)
        }
    }

    suspend fun sendMagicLink(
        address: String,
        email: String,
        endpoint: String,
        fromName: String,
        subject: String,
        textContent: String
    ) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "SendMagicLink")) {
            body = UsersSendMagicLinkRequest(address, email, endpoint, fromName, subject, textContent)
        }
    }

    suspend fun sendPasswordResetEmail(
        email: String,
        fromName: String,
        subject: String,
        textContent: String,
        expiration: Int = 1800,
    ) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "SendPasswordResetEmail")) {
            body = UsersSendPasswordResetEmailRequest(email, expiration, fromName, subject, textContent)
        }
    }

    suspend fun sendVerificationEmail(
        email: String,
        failureRedirectURL: String,
        fromName: String,
        redirectURL: String,
        subject: String,
        textContent: String
    ) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "SendVerificationEmail")) {
            body = UsersSendVerificationEmailRequest(email, failureRedirectURL, fromName, redirectURL, subject, textContent)
        }
    }

    suspend fun update(
        id: String,
        email: String = "",
        profile: Map<String, String> = mapOf(),
        username: String = "",
    ) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Update")) {
            body = UsersUpdateRequest(email, id, profile, username)
        }
    }

    suspend fun updatePassword(
        confirmPassword: String,
        newPassword: String,
        oldPassword: String,
        userID: String
    ) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "UpdatePassword")) {
            body = UsersUpdatePasswordRequest(confirmPassword, newPassword, oldPassword, userID)
        }
    }

    suspend fun verifyEmail(email: String, token: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "VerifyEmail")) {
            body = UsersVerifyEmailRequest(email, token)
        }
    }

    suspend fun verifyToken(token: String): UsersVerifyTokenResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "VerifyToken")) {
            body = UsersVerifyTokenRequest(token)
        }
    }
}