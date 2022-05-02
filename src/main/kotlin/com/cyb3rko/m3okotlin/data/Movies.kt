package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MoviesRequest(
    val language: String,
    val page: Int,
    val primary_release_year: Int,
    val query: String,
    val region: String,
    val year: Int
)

@Serializable
data class MoviesResponse(
    val page: Int,
    val results: List<Movie>,
    @SerialName("total_pages")
    val totalPages: Int,
    @SerialName("total_results")
    val totalResults: Int
) {

    @Serializable
    data class Movie(
        val adult: Boolean,
        @SerialName("backdrop_path")
        val backdropPath: String,
        @SerialName("genre_ids")
        val genreIds: List<Int>,
        val id: Int,
        @SerialName("original_language")
        val originalLanguage: String,
        @SerialName("original_title")
        val originalTitle: String,
        val overview: String,
        val popularity: Float,
        @SerialName("poster_path")
        val posterPath: String,
        @SerialName("release_date")
        val releaseDate: String,
        val title: String,
        val video: Boolean,
        @SerialName("vote_average")
        val voteAverage: Float,
        @SerialName("vote_count")
        val voteCount: Int
    )
}
