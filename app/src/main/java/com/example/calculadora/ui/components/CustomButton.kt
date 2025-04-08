package com.example.calculadora.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun CustomButton(
    onClick: () -> Unit,
    buttonText: String,
    calcButton: Boolean = false,
    selected: Boolean = false
) {

    val buttonColors = when {
        calcButton -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
        )
        selected -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.errorContainer,
            contentColor = MaterialTheme.colorScheme.onErrorContainer
        )
        else -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            contentColor = MaterialTheme.colorScheme.onTertiaryContainer
        )
    }

    ElevatedButton(
        onClick = onClick,
        modifier = Modifier,
        shape = RoundedCornerShape(15.dp),
        colors = buttonColors
    ) {
        Text(text = buttonText, style = MaterialTheme.typography.labelLarge)
    }
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview() {
    CustomButton(
        onClick = {},
        buttonText = "TEXTO",
    )
}