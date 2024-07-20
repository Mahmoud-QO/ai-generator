package com.example.aigenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aigenerator.ui.MainViewModel
import com.example.aigenerator.ui.OnboardingState
import com.example.aigenerator.ui.Route
import com.example.aigenerator.ui.screen.discover.DiscoverScreen
import com.example.aigenerator.ui.screen.onboarding.OnboardingScreen
import com.example.aigenerator.ui.screen.paywall.PaywallScreen
import com.example.aigenerator.ui.theme.AIGeneratorTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AIGeneratorTheme {

                val isOnboardingCompleted by viewModel.isOnboardingCompleted.collectAsState()
                val startDestination = when (isOnboardingCompleted) {
                    OnboardingState.Completed -> Route.DiscoverScreen
                    OnboardingState.NotCompleted -> Route.OnboardingScreen
                    OnboardingState.Loading -> Route.SplashScreen
                }

                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = startDestination) {

                    composable<Route.SplashScreen> { }

                    composable<Route.OnboardingScreen> {
                        OnboardingScreen(navController)
                    }

                    composable<Route.DiscoverScreen> {
                        DiscoverScreen(navController)
                    }

                    composable<Route.PaywallScreen> {
                        PaywallScreen(navController)
                    }

                }
            }
        }
    }
}