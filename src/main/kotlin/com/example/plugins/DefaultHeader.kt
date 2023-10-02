package com.example.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.defaultheaders.*
import java.time.Duration

/**
 * Default Header disini berfungsi sebagai caching
 * penjelasannya adalah pada parameter header yaitu nilai/value yang digunakan untuk mengaktifkan caching gambar
 * pada klien http secara otomatis pada tenggat waktu 365 hari
 */

fun Application.configureDefaultHeader() {
    install(DefaultHeaders) {
        val oneYearInSeconds = Duration.ofDays(365).seconds
        header(
            name = HttpHeaders.CacheControl,
            value = "public, max-age=$oneYearInSeconds, immutable"
        )
    }
}