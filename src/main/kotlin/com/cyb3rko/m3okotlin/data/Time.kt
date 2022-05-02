package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
internal data class TimeNowRequest(val location: String)

@Serializable
data class TimeNowResponse(
    @Serializable(with = LocaltimeSerializer::class)
    val localtime: Localtime,
    val location: String,
    @Serializable(with = TimestampSerializer::class)
    val timestamp: Timestamp,
    val timezone: String,
    val unix: String
) {

    class Localtime internal constructor(private val string: String) {
        val hour: Int
        val minute: Int
        val second: Int

        init {
            val timeParts = string.split(":")
            hour = timeParts[0].toInt()
            minute = timeParts[1].toInt()
            second = timeParts[2].toInt()
        }

        override fun toString() = string
    }

    private object LocaltimeSerializer : KSerializer<Localtime> {
        override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("localtime", PrimitiveKind.STRING)

        override fun serialize(encoder: Encoder, value: Localtime) { }

        override fun deserialize(decoder: Decoder) = Localtime(decoder.decodeString())
    }

    class Timestamp internal constructor(private val string: String) {
        val year: Int
        val month: Int
        val day: Int
        val hour: Int
        val minute: Int
        val second: Int
        val millisecond: Int

        init {
            var timeParts = string.split("-")
            year = timeParts[0].toInt()
            month = timeParts[1].toInt()
            day = timeParts[2].substring(0..1).toInt()
            timeParts = timeParts[2].drop(3).split(":")
            hour = timeParts[0].toInt()
            minute = timeParts[1].toInt()
            second = timeParts[2].substring(0..1).toInt()
            millisecond = timeParts[2].substring(3..11).toInt()
        }

        override fun toString() = string
    }

    private object TimestampSerializer : KSerializer<Timestamp> {
        override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("timestamp", PrimitiveKind.STRING)

        override fun serialize(encoder: Encoder, value: Timestamp) { }

        override fun deserialize(decoder: Decoder) = Timestamp(decoder.decodeString())
    }
}

@Serializable
internal data class TimeZoneRequest(val location: String)

@Serializable
data class TimeZoneResponse(
    val abbreviation: String,
    val country: String,
    val dst: Boolean,
    val latitude: Float,
    @Serializable(with = LocaltimeSerializer::class)
    val localtime: Localtime,
    val location: String,
    val longitude: Float,
    val offset: Int,
    val region: String,
    val timezone: String
) {

    class Localtime internal constructor(private val string: String) {
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

        override fun toString() = string
    }

    private object LocaltimeSerializer : KSerializer<Localtime> {
        override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("localtime", PrimitiveKind.STRING)

        override fun serialize(encoder: Encoder, value: Localtime) { }

        override fun deserialize(decoder: Decoder) = Localtime(decoder.decodeString())
    }
}
