package com.example.aigenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aigenerator.ui.Route
import com.example.aigenerator.ui.screen.discover.DiscoverScreen
import com.example.aigenerator.ui.screen.onboarding.OnboardingScreen
import com.example.aigenerator.ui.screen.paywall.PaywallScreen
import com.example.aigenerator.ui.theme.AIGeneratorTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AIGeneratorTheme {

                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Route.OnboardingScreen) {

                    composable<Route.OnboardingScreen> {
                        OnboardingScreen(navController)
                    }

                    composable<Route.DiscoverScreen> {
                        DiscoverScreen(navController)
                    }

                    composable<Route.PaywallScreen> {
                        PaywallScreen()
                    }

                }
            }
        }
    }
}