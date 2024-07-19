package com.example.aigenerator.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aigenerator.R
import com.example.aigenerator.model.ArtItem
import com.example.aigenerator.model.User
import com.example.aigenerator.ui.theme.AIGeneratorTheme

@Composable
fun ArtItemCard(
    item: ArtItem, modifier: Modifier = Modifier, onSaveItem: (ArtItem) -> Unit
) = Column(
    modifier = modifier.fillMaxWidth().background(MaterialTheme.colorScheme.background),
    verticalArrangement = Arrangement.SpaceBetween
) {

    Box(
        modifier = Modifier.fillMaxWidth().weight(1f, false).clip(RoundedCornerShape(24.dp))
    ) {
        Image(
            painter = painterResource(id = item.imageId),
            contentDescription = item.title,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Button(
            onClick = { onSaveItem(item) },
            modifier = Modifier.padding(12.dp).size(44.dp).align(Alignment.TopEnd),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.background.copy(alpha = 0.1f)
            ),
            contentPadding = PaddingValues(0.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_save),
                contentDescription = stringResource(R.string.save_item),
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = item.artist.profilePictureId),
            contentDescription = null,
            modifier = Modifier.size(24.dp).clip(CircleShape)
        )

        Text(
            text = item.artist.name,
            modifier = Modifier.padding(start = 8.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun Preview() = AIGeneratorTheme {
    ArtItemCard(artItem, Modifier.size(168.dp, 262.dp)) {}
}

private val artItem = ArtItem(
    imageId = R.drawable.leslie_alexander_item,
    artist = User(name = "Leslie Alexander", profilePictureId = R.drawable.leslie_alexander_pic)
)
