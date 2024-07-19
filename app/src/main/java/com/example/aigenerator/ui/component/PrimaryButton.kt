package com.example.aigenerator.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aigenerator.ui.theme.AIGeneratorTheme

@Composable
fun PrimaryButton(
    text: String, modifier: Modifier = Modifier, onClick: () -> Unit
) = Button(
    onClick = { onClick() },
    modifier = modifier.fillMaxWidth().height(64.dp)
) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() = AIGeneratorTheme {
    PrimaryButton("Subscribe for 4.17/Month") {}
}
