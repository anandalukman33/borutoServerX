package com.example

import com.example.di.koinModule
import com.example.model.ApiResponse
import com.example.plugins.configureRouting
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.testing.*
import kotlinx.serialization.json.Json
import org.junit.After
import org.junit.Before
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class NegativeCaseTest {

    @Before
    fun startKoinForTest() {
        startKoin {
            modules(koinModule)
        }
    }

    @After
    fun stopKoinAfterTest() = stopKoin()


    /**
     * Root endpoint
     */
    @Test
    fun `access non existing endpoint, assert blank`() = testApplication {
        application {
            configureRouting()
        }
        client.get("/test123").apply {
            assertEquals(
                expected = HttpStatusCode.NotFound,
                actual = status
            )
            assertNotEquals(
                "Welcome to Boruto API!",
                actual = bodyAsText()
            )
            assertEquals("", body())
        }
    }

    /**
     * All Heroes Endpoint
     */
    @Suppress("DEPRECATION")
    @Test
    fun accessAllHeroesEndpoint_AssertHeroesNotFound() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/boruto/heroes?page=6").apply {
                assertEquals(
                    expected = HttpStatusCode.NotFound,
                    actual = response.status()
                )

                val expectedResponse = ApiResponse(
                    success = false,
                    message = "Heroes not Found."
                )

                val actualResponse = Json.decodeFromString<ApiResponse>(response.content.toString())

                // Result Expected Test
                println("Expected Result is : $expectedResponse")
                // Result Actual Test
                println("Actual Result is : $actualResponse")

                assertEquals(
                    expected = expectedResponse,
                    actual = actualResponse
                )
            }
        }
    }


    /**
     * Search Heroes Endpoint
     */
    @Test
    fun `access search heroes endpoint, query empty param, assert empty list heroes`() = testApplication {
        application { configureRouting() }
        val queryNameParameterTest = "?name="
        client.get("/boruto/heroes/search$queryNameParameterTest").apply {
            assertEquals(
                expected = HttpStatusCode.OK,
                actual = status
            )

            val actualResponseList = Json.decodeFromString<ApiResponse>(body<String>().toString()).heroes

            assertEquals(
                expected = emptyList(),
                actual = actualResponseList
            )

        }
    }

    @Test
    fun `access search heroes endpoint, query non existing hero, assert empty list heroes`() = testApplication {
        application { configureRouting() }
        val queryNameParameterTest = "?name=Lukman"
        client.get("/boruto/heroes/search$queryNameParameterTest").apply {
            assertEquals(
                expected = HttpStatusCode.OK,
                actual = status
            )

            val actualResponseList = Json.decodeFromString<ApiResponse>(body<String>().toString()).heroes

            assertEquals(
                expected = emptyList(),
                actual = actualResponseList
            )

        }
    }

}