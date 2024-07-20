package com.example.aigenerator.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aigenerator.R
import com.example.aigenerator.ui.theme.AIGeneratorTheme

@Composable
fun PromptCard(
    onGenerate: (String) -> Unit, onClose: () -> Unit, modifier: Modifier = Modifier
) = Column(
    modifier = modifier
        .clip(RoundedCornerShape(28.dp))
        .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.8f)),
    horizontalAlignment = Alignment.CenterHorizontally
) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Prompt",
            modifier = Modifier.align(Alignment.Center),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface
        )

        Button(
            onClick = onClose,
            modifier = Modifier.padding(8.dp).size(44.dp).align(Alignment.TopEnd),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(0.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_close),
                contentDescription = "Close Prompt",
                tint = MaterialTheme.colorScheme.onSecondary
            )
        }
    }

    var state by remember {
        mutableStateOf("Type your imagination and let the [App] visualize it.")
    }
    TextField(
        value = state, onValueChange = { state = it },
        modifier = Modifier
            .fillMaxWidth().weight(1f).padding(horizontal = 24.dp)
            .clip(RoundedCornerShape(32.dp))
            .background(MaterialTheme.colorScheme.background.copy(alpha = 0.6f)),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
    )
    Button(
        onClick = { onGenerate(state) },
        modifier = Modifier.padding(24.dp).height(64.dp).fillMaxWidth()
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_magic_stick), contentDescription = null)
        Text(text = "Generate")
    }

}

@Preview(showBackground = true)
@Composable
private fun Preview() = AIGeneratorTheme {
    PromptCard({}, {}, Modifier.fillMaxWidth().height(600.dp))
}
