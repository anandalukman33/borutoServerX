package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val success: Boolean,
    val message: String? = null,
    val prevPage: Int? = null,
    val nextPage: Int? = null,
    val heroes: List<Hero>? = emptyList(),

    // for Remote Mediator Initialize for caching data if Response API unavailable
    val lastUpdated: Long? = null
)
