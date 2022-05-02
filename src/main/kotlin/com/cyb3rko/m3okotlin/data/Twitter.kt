package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Requests & Responses + Data (single use)

@Serializable
internal data class TwitterSearchRequest(val limit: Int, val query: String)

@Serializable
data class TwitterSearchResponse(val tweets: List<Tweet>)

@Serializable
internal data class TwitterTimelineRequest(val limit: Int, val username: String)

@Serializable
data class TwitterTimelineResponse(val tweets: List<Tweet>)

@Serializable
data class TwitterTrendsResponse(val trends: List<TwitterTrend>) {

    @Serializable
    data class TwitterTrend(
        val name: String,
        @SerialName("tweet_volume")
        val tweetVolume: String,
        val url: String
    )
}

@Serializable
internal data class TwitterUserRequest(val username: String)

@Serializable
data class TwitterUserResponse(val profile: TwitterProfile, val status: TwitterStatus) {

    @Serializable
    data class TwitterProfile(
        @SerialName("created_at")
        val createdAt: String,
        val description: String,
        val followers: String,
        val id: String,
        @SerialName("image_url")
        val imageUrl: String,
        val location: String,
        val name: String,
        val private: Boolean,
        val username: String,
        val verified: Boolean
    )

    @Serializable
    data class TwitterStatus(
        @SerialName("created_at")
        val createdAt: String,
        @SerialName("favourited_count")
        val favouritedCount: String,
        val id: String,
        @SerialName("retweeted_count")
        val retweetedCount: String,
        val text: String,
        val username: String
    )
}

// Data (multiple use)

@Serializable
data class Tweet(
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("favourited_count")
    val favouritedCount: String,
    val id: String,
    @SerialName("retweeted_count")
    val retweetedCount: String,
    val text: String,
    val username: String
)
