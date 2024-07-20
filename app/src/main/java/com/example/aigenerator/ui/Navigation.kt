package com.example.aigenerator.ui

import kotlinx.serialization.Serializable

sealed class Route {

    @Serializable
    data object SplashScreen: Route()

    @Serializable
    data object OnboardingScreen: Route()

    @Serializable
    data object DiscoverScreen: Route()

    @Serializable
    data object PaywallScreen: Route()

}