package com.example.aigenerator.ui.screen.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.aigenerator.ui.Route
import com.example.aigenerator.ui.theme.AIGeneratorTheme

@Composable
fun OnboardingScreen(
    navController: NavController
) {
    OnboardingScreenContent { navController.navigate(Route.DiscoverScreen) }
}

@Composable
private fun OnboardingScreenContent(onLetGo: () -> Unit) = Row(
    modifier = Modifier.fillMaxSize().navigationBarsPadding(),
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.Bottom
) {
    Button(onClick = { onLetGo() }) {
        Text(text = "Let's go!")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun OnboardingScreenPreview() = AIGeneratorTheme {
    OnboardingScreenContent {}
}