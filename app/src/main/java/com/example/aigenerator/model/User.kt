package com.example.aigenerator.model

data class User(
    val id: Int = 0,
    val name: String,
    val profilePictureId: Int,
    val subscription: Subscription = Subscription.NoSubscription
)

