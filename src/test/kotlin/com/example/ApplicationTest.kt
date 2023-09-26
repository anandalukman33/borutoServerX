package com.example

import com.example.di.koinModule
import com.example.model.ApiResponse
import com.example.plugins.configureRouting
import com.example.repository.HeroRepository
import com.example.repository.constant.ConstantRepo
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
import org.koin.java.KoinJavaComponent.inject
import kotlin.test.Test
import kotlin.test.assertEquals


class ApplicationTest {

    private val heroRepository: HeroRepository by inject(HeroRepository::class.java)

    @Before
    fun startKoinForTest() {
        startKoin {
            modules(koinModule)
        }
    }

    @After
    fun stopKoinAfterTest() = stopKoin()


    /**
     * Root or Default endpoint
     */
    @Test
    fun accessRootEndpoint_AssertCorrectInformation() = testApplication {
        application {
            configureRouting()
        }
        client.get("/").apply {
            assertEquals(
                expected = HttpStatusCode.OK,
                actual = status
            )
            assertEquals(
                expected = "Welcome to Boruto API!",
                actual = bodyAsText()
            )
        }
    }

    /**
     * Endpoint for collect heroes or get list of heroes.
     */
    @Suppress("DEPRECATION")
    @Test
    fun accessAllHeroesEndpoint_AssertCorrectInformation() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/boruto/heroes").apply {
                assertEquals(
                    expected = HttpStatusCode.OK,
                    actual = response.status()
                )

                val expectedResponse = ApiResponse(
                    success = true,
                    message = "Ok",
                    prevPage = calculatePage(
                        request.queryParameters["page"]?.toInt() ?: 0
                    )[ConstantRepo.PREVIOUS_PAGE_KEY],
                    nextPage = calculatePage(request.queryParameters["page"]?.toInt() ?: 0)[ConstantRepo.NEXT_PAGE_KEY],
                    heroes = when (request.queryParameters["page"]?.toInt() ?: 0) {
                        0 -> {
                            heroRepository.page1
                        }

                        1 -> {
                            heroRepository.page1
                        }

                        2 -> {
                            heroRepository.page2
                        }

                        3 -> {
                            heroRepository.page3
                        }

                        4 -> {
                            heroRepository.page4
                        }

                        5 -> {
                            heroRepository.page5
                        }

                        else -> {
                            emptyList()
                        }
                    }
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

    @Suppress("DEPRECATION")
    @Test
    fun accessAllHeroesEndpoint_WithQueryPage2_AssertCorrectInformation() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/boruto/heroes?page=2").apply {
                assertEquals(
                    expected = HttpStatusCode.OK,
                    actual = response.status()
                )

                val page = request.queryParameters["page"]?.toInt() ?: 0

                val expectedResponse = ApiResponse(
                    success = true,
                    message = "Ok",
                    prevPage = calculatePage(page)[ConstantRepo.PREVIOUS_PAGE_KEY],
                    nextPage = calculatePage(page)[ConstantRepo.NEXT_PAGE_KEY],
                    heroes = when (request.queryParameters["page"]?.toInt() ?: 0) {
                        0 -> {
                            heroRepository.page1
                        }

                        1 -> {
                            heroRepository.page1
                        }

                        2 -> {
                            heroRepository.page2
                        }

                        3 -> {
                            heroRepository.page3
                        }

                        4 -> {
                            heroRepository.page4
                        }

                        5 -> {
                            heroRepository.page5
                        }

                        else -> {
                            emptyList()
                        }
                    }
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

    @Test
    fun accessAllHeroesEndpoint_QueryAllPage_AssertCorrectInformation() = testApplication {
        application { configureRouting() }

        val pages = 1..5
        val heroes = listOf(
            heroRepository.page1,
            heroRepository.page2,
            heroRepository.page3,
            heroRepository.page4,
            heroRepository.page5,
        )

        pages.forEach { page ->
            client.get("/boruto/heroes?page=$page").apply {
                assertEquals(
                    expected = HttpStatusCode.OK,
                    actual = status
                )
                val expectedResponse = ApiResponse(
                    success = true,
                    message = "Ok",
                    prevPage = calculatePage(page)[ConstantRepo.PREVIOUS_PAGE_KEY],
                    nextPage = calculatePage(page)[ConstantRepo.NEXT_PAGE_KEY],
                    heroes = heroes[page - 1] // dibuat agar sesuai index list ex: (page = 1 == list[0])
                )

                val actualResponse = Json.decodeFromString<ApiResponse>(body<String>().toString())
                assertEquals(
                    expected = expectedResponse,
                    actual = actualResponse
                )
            }
        }

    }


    /**
     * Endpoint for search name heroes.
     */
    @Test
    fun `access search heroes endpoint, query hero name, assert single hero result`() = testApplication {
        application { configureRouting() }
        val queryNameParameterTest = "?name=sas"
        client.get("/boruto/heroes/search$queryNameParameterTest").apply {
            assertEquals(
                expected = HttpStatusCode.OK,
                actual = status
            )

            val actualResponseListSize = Json.decodeFromString<ApiResponse>(body<String>().toString()).heroes?.size

            // Make sure list response just 1 index
            assertEquals(
                expected = 1,
                actual = actualResponseListSize
            )

            val actualResponse = Json.decodeFromString<ApiResponse>(body<String>().toString()).heroes
            val heroBean = actualResponse?.get(0)

            // Make sure name hero is Uchiha Sasuke with paramQuery 'sas'
            assertEquals(expected = "Uchiha Sasuke", actual = heroBean?.name ?: "")
        }
    }

    @Test
    fun `access search heroes endpoint, query hero name, assert multiple hero result`() = testApplication {
        application { configureRouting() }
        val queryNameParameterTest = "?name=sa"
        client.get("/boruto/heroes/search$queryNameParameterTest").apply {
            assertEquals(
                expected = HttpStatusCode.OK,
                actual = status
            )

            val actualResponseListSize = Json.decodeFromString<ApiResponse>(body<String>().toString()).heroes?.size

            // Make sure list response just 1 index
            if (actualResponseListSize != null) {
                assertEquals(
                    expected = true,
                    actual = actualResponseListSize > 0
                )
            }

            val actualResponse = Json.decodeFromString<ApiResponse>(body<String>().toString()).heroes

            val expectedNameHeroList = listOf("Amado Sanzu", "Uchiha Sasuke", "Uchiha Sakura")
            expectedNameHeroList.forEach { heroName ->
                actualResponse?.forEach { i ->
                    if (heroName == i.name) {
                        // Make sure name hero is equals with dummy list variable (expectedNameHeroList).
                        assertEquals(expected = heroName, actual = i.name)
                    }
                }
            }

        }
    }


    /**
     * Utility function
     */
    private fun calculatePage(page: Int?) : Map<String, Int?> {
        var prevPage: Int? = page
        var nextPage: Int? = page

        if (page in 1..4) {
            nextPage = nextPage?.plus(1)
        }
        if (page in 2..5) {
            prevPage = prevPage?.minus(1)
        }
        if (page == 1) {
            prevPage = null
        }
        if (page == 5) {
            nextPage = null
        }
        if (page == 0) {
            prevPage = null
            nextPage = 2
        }

        return mapOf("prevPage" to prevPage, "nextPage" to nextPage)
    }
}



