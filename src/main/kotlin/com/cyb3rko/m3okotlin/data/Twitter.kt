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
        val url: String,
        @SerialName("tweet_volume")
        val tweetVolume: String
    )
}

@Serializable
internal data class TwitterUserRequest(val username: String)

@Serializable
data class TwitterUserResponse(val profile: TwitterProfile, val status: TwitterStatus) {

    @Serializable
    data class TwitterProfile(
        val id: String,
        val name: String,
        val username: String,
        val description: String,
        @SerialName("created_at")
        val createdAt: String,
        val location: String,
        val followers: String,
        val private: Boolean,
        val verified: Boolean,
        @SerialName("image_url")
        val imageUrl: String
    )

    @Serializable
    data class TwitterStatus(
        val id: String,
        val text: String,
        val username: String,
        @SerialName("created_at")
        val createdAt: String,
        @SerialName("retweeted_count")
        val retweetedCount: String,
        @SerialName("favourited_count")
        val favouritedCount: String
    )
}

// Data (multiple use)

@Serializable
data class Tweet(
    val id: String,
    val text: String,
    val username: String,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("retweeted_count")
    val retweetedCount: String,
    @SerialName("favourited_count")
    val favouritedCount: String
)