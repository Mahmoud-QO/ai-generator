package com.example.aigenerator.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aigenerator.R
import com.example.aigenerator.ui.theme.AIGeneratorTheme

@Composable
fun RatingStars(rating: Int, modifier: Modifier = Modifier) = Row(modifier = modifier) {
    for (i in 1..5) {
        Icon(
            painter = painterResource(id = R.drawable.ic_star),
            contentDescription = null,
            modifier = Modifier.size(16.dp),
            tint = if (i <= rating) MaterialTheme.colorScheme.tertiary
                else MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() = AIGeneratorTheme {
    RatingStars(4, Modifier.background(MaterialTheme.colorScheme.surface))
}
