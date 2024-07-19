package com.example.aigenerator.model

data class UserReview(
    val id: Int = 0,
    val user: User,
    val review: String,
    val rating: Int
)
