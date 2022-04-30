package com.cyb3rko.m3okotlin

import java.util.logging.Logger

internal object Log {
    private lateinit var log: Logger

    internal fun initialize() {
        log = Logger.getLogger(M3O::class.java.name)
    }

    internal fun i(message: String) = log.info(message)

    internal fun e(message: String) = log.severe(message)
}
