package com.example.aigenerator.ui.screen.discover

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.aigenerator.R
import com.example.aigenerator.model.ArtItem
import com.example.aigenerator.model.User
import com.example.aigenerator.ui.Route
import com.example.aigenerator.ui.component.ArtItemCard
import com.example.aigenerator.ui.component.PromptCard
import com.example.aigenerator.ui.component.NavigationBar
import com.example.aigenerator.ui.theme.AIGeneratorTheme

@Composable
fun DiscoverScreen(
    navController: NavController,
    viewModel: DiscoverViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.navigateToPaywall.collect { navController.navigate(Route.PaywallScreen) }
    }

    val readyToGenerate by viewModel.readyToGenerate.collectAsState()
    DiscoverScreenContent(readyToGenerate, viewModel::onEvent)
}

@Composable
private fun DiscoverScreenContent(readyToGenerate: Boolean, onEvent: (DiscoverEvent) -> Unit) = Box(
    modifier = Modifier
        .fillMaxSize().background(MaterialTheme.colorScheme.background).statusBarsPadding()
) {
    Column {
        NavigationBar(
            title = "Discover",
            onAdd = { onEvent(DiscoverEvent.ClickAddArt) },
            onSettings = { /*TODO*/ }
        )

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalItemSpacing = 16.dp
        ) {
            itemsIndexed(artItems) { i, it ->
                ArtItemCard(it, Modifier.height(if (i == 0) 180.dp else 260.dp)) { /*TODO*/ }
            }
        }
    }

    if (readyToGenerate) {
        PromptCard(
            onGenerate = {},
            onClose = { onEvent(DiscoverEvent.ClickClosePrompt) },
            modifier = Modifier
                .fillMaxWidth().fillMaxHeight(0.55f).align(Alignment.BottomCenter)
        )
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
private fun DiscoverScreenPreview() = AIGeneratorTheme {
    DiscoverScreenContent(readyToGenerate = true) {}
}

private val artItems = listOf(
    ArtItem(
        imageId = R.drawable.guy_hawkins_item,
        artist = User(name = "Guy Hawkins", profilePictureId = R.drawable.guy_hawkins_pic)
    ),
    ArtItem(
        imageId = R.drawable.leslie_alexander_item,
        artist = User(name = "Leslie Alexander", profilePictureId = R.drawable.leslie_alexander_pic)
    ),
    ArtItem(
        imageId = R.drawable.kristin_watson_item,
        artist = User(name = "Kristina Watson", profilePictureId = R.drawable.kristin_watson_pic)
    ),
    ArtItem(
        imageId = R.drawable.bessie_cooper_item,
        artist = User(name = "Bessie Cooper", profilePictureId = R.drawable.bessie_cooper_pic)
    ),
    ArtItem(
        imageId = R.drawable.darrell_steward_item,
        artist = User(name = "Darrell Steward", profilePictureId = R.drawable.darrell_steward_pic)
    ),
    ArtItem(
        imageId = R.drawable.darrell_steward_item1,
        artist = User(name = "Darrell Steward", profilePictureId = R.drawable.darrell_steward_pic)
    ),
    ArtItem(
        imageId = R.drawable.guy_hawkins_item,
        artist = User(name = "Guy Hawkins", profilePictureId = R.drawable.guy_hawkins_pic)
    ),
    ArtItem(
        imageId = R.drawable.leslie_alexander_item,
        artist = User(name = "Leslie Alexander", profilePictureId = R.drawable.leslie_alexander_pic)
    ),
    ArtItem(
        imageId = R.drawable.kristin_watson_item,
        artist = User(name = "Kristina Watson", profilePictureId = R.drawable.kristin_watson_pic)
    ),
    ArtItem(
        imageId = R.drawable.bessie_cooper_item,
        artist = User(name = "Bessie Cooper", profilePictureId = R.drawable.bessie_cooper_pic)
    ),
    ArtItem(
        imageId = R.drawable.darrell_steward_item,
        artist = User(name = "Darrell Steward", profilePictureId = R.drawable.darrell_steward_pic)
    ),
    ArtItem(
        imageId = R.drawable.darrell_steward_item1,
        artist = User(name = "Darrell Steward", profilePictureId = R.drawable.darrell_steward_pic)
    )
)