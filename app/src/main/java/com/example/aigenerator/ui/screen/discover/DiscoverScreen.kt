package com.example.aigenerator.ui.screen.discover

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aigenerator.R
import com.example.aigenerator.model.ArtItem
import com.example.aigenerator.model.User
import com.example.aigenerator.ui.Route
import com.example.aigenerator.ui.component.ArtItemCard
import com.example.aigenerator.ui.component.NavigationBar
import com.example.aigenerator.ui.theme.AIGeneratorTheme

@Composable
fun DiscoverScreen(
    navController: NavController
) {
    DiscoverScreenContent { navController.navigate(Route.PaywallScreen) }
}

@Composable
private fun DiscoverScreenContent(onAdd: () -> Unit) = Column(
    modifier = Modifier
        .fillMaxSize().background(MaterialTheme.colorScheme.background).statusBarsPadding()
) {
    NavigationBar(title = "Discover", onAdd = { onAdd() }, onSettings = { /*TODO*/ })

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalItemSpacing = 16.dp
    ) {
        itemsIndexed(artItems) {i, it ->
            ArtItemCard(it, Modifier.height(if (i == 0) 180.dp else 260.dp)) { /*TODO*/ }
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
private fun DiscoverScreenPreview() = AIGeneratorTheme {
    DiscoverScreenContent {}
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