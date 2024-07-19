package com.example.aigenerator.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aigenerator.R
import com.example.aigenerator.ui.theme.AIGeneratorTheme

@Composable
fun NavigationBar(
    title: String, onAdd: () -> Unit, onSettings: () -> Unit, modifier: Modifier = Modifier
) = Row(
    modifier = modifier
        .fillMaxWidth().background(MaterialTheme.colorScheme.background).padding(8.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
) {

    Button(
        onClick = { onSettings() },
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp).size(44.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
        contentPadding = PaddingValues(0.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_settings),
            contentDescription = stringResource(R.string.settings),
            tint = MaterialTheme.colorScheme.onSecondary
        )
    }

    Text(
        text = title,
        color = MaterialTheme.colorScheme.onBackground,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.SemiBold,
    )

    Button(
        onClick = { onAdd() },
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp).size(44.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
        contentPadding = PaddingValues(0.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_add),
            contentDescription = stringResource(R.string.add),
            tint = MaterialTheme.colorScheme.primary
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun Preview() = AIGeneratorTheme {
    NavigationBar("Discover", {}, {})
}
