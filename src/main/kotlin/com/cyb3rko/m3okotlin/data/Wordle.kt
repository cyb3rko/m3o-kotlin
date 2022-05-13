package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class WordleGuessRequest(val player: String, val word: String)

@Serializable
data class WordleGuessResponse(
    val answer: String,
    val correct: Boolean,
    val guesses: List<Guess>,
    val status: String,
    @SerialName("tries_left")
    val triesLeft: Int
) {

    @Serializable
    data class Guess(
        val chars: List<GuessChar>,
        val highlight: String,
        val word: String
    ) {

        @Serializable
        data class GuessChar(
            val correct: Boolean,
            @SerialName("in_word")
            val inWord: Boolean,
            val letter: String,
            val position: Int
        )
    }
}

@Serializable
data class WordleNextResponse(val duration: String, val seconds: Int)
