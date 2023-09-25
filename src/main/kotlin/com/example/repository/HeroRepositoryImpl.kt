package com.example.repository

import com.example.model.ApiResponse
import com.example.model.Hero

class HeroRepositoryImpl(
    override val heroes: Map<Int, List<Hero>>,
    override val page1: List<Hero>,
    override val page2: List<Hero>,
    override val page3: List<Hero>,
    override val page4: List<Hero>,
    override val page5: List<Hero>
) : HeroRepository {
    override suspend fun getAllHeroes(page: Int): ApiResponse {
        TODO("Not yet implemented")
    }

    override suspend fun searchHeroes(name: String): ApiResponse {
        TODO("Not yet implemented")
    }
}