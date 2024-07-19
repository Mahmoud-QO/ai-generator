package com.example.aigenerator.ui.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aigenerator.R
import com.example.aigenerator.ui.Route
import com.example.aigenerator.ui.theme.AIGeneratorTheme

@Composable
fun OnboardingScreen(
    navController: NavController
) {
    OnboardingScreenContent { navController.navigate(Route.DiscoverScreen) }
}

@Composable
private fun OnboardingScreenContent(onLetGo: () -> Unit) = Box(
    modifier = Modifier
        .fillMaxSize().background(MaterialTheme.colorScheme.background).navigationBarsPadding(),
) {

    Box(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(0.65f).align(Alignment.TopCenter)
    ) {
        Image(
            painter = painterResource(id = R.drawable.onboarding_background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize().padding(bottom = 4.dp),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier.fillMaxSize().background(
                brush = Brush.verticalGradient(
                    0f to Color.Transparent,
                    1f to MaterialTheme.colorScheme.background
                )
            )
        )
    }


    Column(
        modifier = Modifier
            .fillMaxWidth().fillMaxHeight(0.5f)
            .align(Alignment.BottomCenter).padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()).weight(1f, false),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.onboarding_headline),
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource(R.string.onboarding_body),
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.onSecondary,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            modifier = Modifier.fillMaxWidth().height(64.dp),
            onClick = { onLetGo() }
        ) {
            Text(
                text = stringResource(R.string.let_go),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
        }
    }

}

/*
@Preview(showBackground = true, device = "id:2.7in QVGA", showSystemUi = true)
@Preview(showBackground = true, device = "id:3.7in WVGA (Nexus One)", showSystemUi = true)
@Preview(showBackground = true, device = "id:small_phone", showSystemUi = true)

@Preview(showBackground = true, device = "id:5.1in WVGA", showSystemUi = true)
@Preview(showBackground = true, device = "id:medium_phone", showSystemUi = true)
@Preview(showBackground = true, device = "id:6.7in Foldable", showSystemUi = true)

@Preview(showBackground = true, device = "id:7in WSVGA (Tablet)", showSystemUi = true)
@Preview(showBackground = true, device = "id:7.6in Foldable", showSystemUi = true)
@Preview(showBackground = true, device = "id:8in Foldable", showSystemUi = true)

@Preview(showBackground = true, device = "id:medium_tablet", showSystemUi = true)
@Preview(showBackground = true, device = "id:10.1in WXGA (Tablet)", showSystemUi = true)
@Preview(showBackground = true, device = "id:13.5in Freeform", showSystemUi = true)
*/
@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun OnboardingScreenPreview() = AIGeneratorTheme {
    OnboardingScreenContent {}
}