package com.example.plugins

import com.example.model.Person
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.*

fun Application.configureRouting() {
    routing {
        staticResources("/", "static")

        get("/") {
            call.respondText("Hello World")
        }

        get("/users/{username}") {
            val username = call.parameters["username"]
            val header = call.request.headers["Connection"]

            if (username == "Admin") {
                call.response.header(name = "CustomHeader", value = "Admin")
                call.respond(message = "Hello Admin", status = HttpStatusCode.OK)
            }

            call.respondText("Hi im $username with header : $header")
        }

        get("/user") {
            //val name = call.request.queryParameters["name"]
            //val age = call.request.queryParameters["age"]
            //call.respondText("Hi my name $name, Im $age years old!")
            call.respondRedirect(url = "/userApiDisabled", permanent = true)
        }

        get("/person") {
            try {
                val personMock = Person(
                    id = 1,
                    name = "Ananda Muhamad Lukman",
                    age = 25,
                    city = "Jakarta",
                    hobby = "Coding",
                    gender = 'M',
                    isActive = true
                )
                call.respond(message = personMock, status = HttpStatusCode.OK)
            } catch (e: Exception) {
                call.respond(message = e.message.toString(), status = HttpStatusCode.BadRequest)
            }
        }

        get("/userApiDisabled") {
            call.respondText("Sorry api User has been disabled by admin!")
        }

        get("/exampleHtml") {
            val param = call.request.queryParameters["name"]
            call.respondHtml {
                head {
                    title("Custom Title")
                }

                body {
                    if (param.isNullOrBlank()) {
                        h3 {+"Welcome to the Junggle"}
                    } else {
                        h3{+"Hi Im $param"}
                    }
                    p{+"Current Directory is ${System.getProperty("user.dir")}"}
                    img(src = "sample.jpg")
                }
            }
        }

    }
}
