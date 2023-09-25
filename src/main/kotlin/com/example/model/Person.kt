package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Person (
    val id: Int,
    val name: String,
    val age: Int,
    val city: String,
    val hobby: String,
    val gender: Char,
    val isActive: Boolean
)