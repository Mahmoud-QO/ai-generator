package com.example.aigenerator.ui.screen.discover

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aigenerator.ui.Route
import com.example.aigenerator.ui.theme.AIGeneratorTheme

@Composable
fun DiscoverScreen(
    navController: NavController
) {
    DiscoverScreenContent { navController.navigate(Route.PaywallScreen) }
}

@Composable
private fun DiscoverScreenContent(onAdd: () -> Unit) = Row(
    modifier = Modifier.fillMaxSize().statusBarsPadding(),
    horizontalArrangement = Arrangement.End,
    verticalAlignment = Alignment.Top
) {
    Button(
        onClick = { onAdd() },
        modifier = Modifier.padding(16.dp).size(48.dp),
        shape = CircleShape,
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(text = "+")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun DiscoverScreenPreview() = AIGeneratorTheme {
    DiscoverScreenContent {}
}