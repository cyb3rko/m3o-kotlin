package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
internal data class WeatherForecastRequest(val days: Int, val location: String)

@Serializable
data class WeatherForecastResponse(
    val country: String,
    val forecast: List<WeatherDayForecast>,
    val latitude: Float,
    @SerialName("local_time")
    @Serializable(with = DateTimeSerializer::class)
    val localTime: DateTime,
    val location: String,
    val longitude: Float,
    val region: String,
    val timezone: String
) {

    @Serializable
    data class WeatherDayForecast(
        @SerialName("avg_temp_c")
        val avgTempC: Float,
        @SerialName("avg_temp_f")
        val avgTempF: Float,
        @SerialName("chance_of_rain")
        val chanceOfRain: Int,
        val condition: String,
        @Serializable(with = DateSerializer::class)
        val date: Date,
        @SerialName("icon_url")
        val iconUrl: String,
        @SerialName("max_temp_c")
        val maxTempC: Float,
        @SerialName("max_temp_f")
        val maxTempF: Float,
        @SerialName("max_wind_kph")
        val maxWindKph: Float,
        @SerialName("max_wind_mph")
        val maxWindMph: Float,
        @SerialName("min_temp_c")
        val minTempC: Float,
        @SerialName("min_temp_f")
        val minTempF: Float,
        @Serializable(with = TimeSerializer::class)
        val sunrise: Time,
        @Serializable(with = TimeSerializer::class)
        val sunset: Time,
        @SerialName("will_it_rain")
        val willItRain: Boolean
    )
}

@Serializable
internal data class WeatherNowRequest(val location: String)

@Serializable
data class WeatherNowResponse(
    val cloud: Int,
    val condition: String,
    val country: String,
    val daytime: Boolean,
    @SerialName("feels_like_c")
    val feelsLikeC: Float,
    @SerialName("feels_like_f")
    val feelsLikeF: Float,
    val humidity: Int,
    @SerialName("icon_url")
    val iconUrl: String,
    val latitude: Float,
    @SerialName("local_time")
    @Serializable(with = DateTimeSerializer::class)
    val localTime: DateTime,
    val location: String,
    val longitude: Float,
    val region: String,
    @SerialName("temp_c")
    val tempC: Float,
    @SerialName("temp_f")
    val tempF: Float,
    val timezone: String,
    @SerialName("wind_degree")
    val windDegree: Int,
    @SerialName("wind_direction")
    val windDirection: String,
    @SerialName("wind_kph")
    val windKph: Float,
    @SerialName("wind_mph")
    val windMph: Float
)

class DateTime internal constructor(private val string: String) {
    val year: Int
    val month: Int
    val day: Int

    val hour: Int
    val minute: Int

    init {
        val dateTime = string.split(" ")

        val dateParts = dateTime[0].split("-")
        year = dateParts[0].toInt()
        month = dateParts[1].toInt()
        day = dateParts[2].toInt()

        val timeParts = dateTime[1].split(":")
        hour = timeParts[0].toInt()
        minute = timeParts[1].toInt()
    }

    override fun toString(): String {
        return string
    }
}

class Date internal constructor(private val string: String) {
    val year: Int
    val month: Int
    val day: Int

    init {
    val dateParts = string.split("-")
        year = dateParts[0].toInt()
        month = dateParts[1].toInt()
        day = dateParts[2].toInt()
    }

    override fun toString(): String {
        return string
    }
}

class Time internal constructor(private val string: String) {
    val hour: Int
    val minute: Int

    init {
        val timeParts = string.split(":")
        hour = if (timeParts[1][3] == 'A') timeParts[0].toInt() else timeParts[0].toInt() + 12
        minute = timeParts[1].dropLast(3).toInt()
    }

    override fun toString(): String {
        return string
    }
}

object DateTimeSerializer : KSerializer<DateTime> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("local_time", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: DateTime) { }

    override fun deserialize(decoder: Decoder): DateTime {
        return DateTime(decoder.decodeString())
    }
}

object DateSerializer : KSerializer<Date> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("date", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Date) { }

    override fun deserialize(decoder: Decoder): Date {
        return Date(decoder.decodeString())
    }
}

object TimeSerializer : KSerializer<Time> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("time", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Time) { }

    override fun deserialize(decoder: Decoder): Time {
        return Time(decoder.decodeString())
    }
}
