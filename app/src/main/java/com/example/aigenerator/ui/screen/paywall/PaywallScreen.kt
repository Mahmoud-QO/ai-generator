package com.example.aigenerator.ui.screen.paywall

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.aigenerator.ui.theme.AIGeneratorTheme

@Composable
fun PaywallScreen() {
    PaywallScreenContent()
}

@Composable
private fun PaywallScreenContent() {

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PaywallScreenPreview() = AIGeneratorTheme {
    PaywallScreenContent()
}