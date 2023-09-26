package com.example

import com.example.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

@Suppress("unused")
fun Application.module() {
    configureStatusPage()
    configureDefaultHeader()
    configureKoin()
    configureSerialization()
    configureHTTP()
    configureMonitoring()
    configureRouting()
    contentNegotiation()
}
