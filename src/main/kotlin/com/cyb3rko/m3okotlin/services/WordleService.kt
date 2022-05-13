package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.WordleGuessRequest
import com.cyb3rko.m3okotlin.data.WordleGuessResponse
import com.cyb3rko.m3okotlin.data.WordleNextResponse
import io.ktor.client.request.*

private const val SERVICE = "wordle"

/**
 * **Multiplayer wordle**
 *
 * Guess the WORDLE in six tries. Each guess must be a valid five-letter word.
 *
 * @since 0.2.1
 */
object WordleService {

    /**
     * Make a guess
     * @since 0.2.1
     */
    suspend fun guess(word: String, player: String = ""): WordleGuessResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Guess")) {
            body = WordleGuessRequest(player, word)
        }
    }

    /**
     * When does the next game start
     * @since 0.2.1
     */
    suspend fun next(): WordleNextResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Next"))
    }
}
