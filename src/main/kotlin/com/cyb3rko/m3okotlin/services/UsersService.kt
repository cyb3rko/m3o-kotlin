package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "user"

/**
 * **Authentication and user management**
 *
 * The user service provides user account management and authentication. It
 * includes the ability to send verification and password reset emails.
 *
 * @since 0.1.0
 */
object UsersService {

    /**
     * Create a new user account. The email address and username for the account
     * must be unique.
     * @since 0.1.0
     */
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

    /**
     * Delete an account by id
     * @since 0.1.0
     */
    suspend fun delete(id: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = UsersDeleteRequest(id)
        }
    }

    /**
     * List all users. Returns a paged list of results
     * @since 0.1.0
     */
    suspend fun list(limit: Int = 25, offset: Int = 0): UsersListResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "List")) {
            body = UsersListRequest(limit, offset)
        }
    }

    /**
     * Login using username or email. The response will return a new session for
     * successful login, 401 in the case of login failure and 500 for any other
     * error
     * @since 0.1.0
     */
    suspend fun login(
        password: String,
        email: String = "",
        username: String = "",
    ): UsersLoginResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Login")) {
            body = UsersLoginRequest(email, password, username)
        }
    }

    /**
     * Logout a user account
     * @since 0.1.0
     */
    suspend fun logout(sessionID: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Logout")) {
            body = UsersLogoutRequest(sessionID)
        }
    }

    /**
     * Logout of all user's sessions
     * @since 0.1.0
     */
    suspend fun logoutAll(userID: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "LogoutAll")) {
            body = UsersLogoutAllRequest(userID)
        }
    }

    /**
     * Read an account by id, username or email. Only one need to be specified.
     * @since 0.1.0
     */
    suspend fun read(
        email: String = "",
        id: String = "",
        username: String = "",
    ): UsersReadResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Read")) {
            body = UsersReadRequest(email, id, username)
        }
    }

    /**
     * Read a session by the session id. In the event it has expired or is not
     * found and error is returned.
     * @since 0.1.0
     */
    suspend fun readSession(sessionID: String): UsersReadSessionResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "ReadSession")) {
            body = UsersReadSessionRequest(sessionID)
        }
    }

    /**
     * Reset password with the code sent by the "SendPasswordResetEmail"
     * endpoint.
     * @since 0.1.0
     */
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

    /**
     * Login using email only - Passwordless
     * @since 0.1.0
     */
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

    /**
     * Send an email with a verification code to reset password. Call
     * "ResetPassword" endpoint once user provides the code.
     * @since 0.1.0
     */
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

    /**
     * Send a verification email to a user.
     * @since 0.1.0
     */
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

    /**
     * Update the account username or email
     * @since 0.1.0
     */
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

    /**
     * Update the account password
     * @since 0.1.0
     */
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

    /**
     * Verify the email address of an account from a token sent in an email to
     * the user.
     * @since 0.1.0
     */
    suspend fun verifyEmail(email: String, token: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "VerifyEmail")) {
            body = UsersVerifyEmailRequest(email, token)
        }
    }

    /**
     * Check whether the token attached to MagicLink is valid or not. Ideally,
     * you need to call this endpoint from your http request handler that
     * handles the endpoint which is specified in the SendMagicLink request.
     * @since 0.1.0
     */
    suspend fun verifyToken(token: String): UsersVerifyTokenResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "VerifyToken")) {
            body = UsersVerifyTokenRequest(token)
        }
    }
}
