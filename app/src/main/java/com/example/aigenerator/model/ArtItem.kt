package com.example.aigenerator.model

data class ArtItem(
    val id: Int = 0,
    val imageId: Int,
    val artist: User,
    val title: String? = null,
    val description: String? = null
)
