package com.example.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import javax.naming.AuthenticationException

fun Application.configureStatusPage() {
    install(StatusPages) {
        status(HttpStatusCode.NotFound) { call, statusCode ->
            call.respond(
                message = "Page Not Found.",
                status = statusCode
            )
        }
        exception<AuthenticationException> { call, errorMessage ->
            call.respond(
                message = "We caught an Exception : ${errorMessage.localizedMessage}",
                status = HttpStatusCode.InternalServerError
            )
        }
    }
}