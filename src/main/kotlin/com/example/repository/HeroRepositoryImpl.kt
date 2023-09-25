package com.example.repository

import com.example.model.ApiResponse
import com.example.model.Hero

class HeroRepositoryImpl(
    override val heroes: Map<Int, List<Hero>> = emptyMap(),
    override val page1: List<Hero> = emptyList(),
    override val page2: List<Hero> = emptyList(),
    override val page3: List<Hero> = emptyList(),
    override val page4: List<Hero> = emptyList(),
    override val page5: List<Hero> = emptyList()
) : HeroRepository {
    override suspend fun getAllHeroes(page: Int): ApiResponse {
        TODO("Not yet implemented")
    }

    override suspend fun searchHeroes(name: String): ApiResponse {
        TODO("Not yet implemented")
    }
}