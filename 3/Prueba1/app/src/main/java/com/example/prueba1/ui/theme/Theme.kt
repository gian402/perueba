package com.example.prueba1.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

/**
 * Application theme wrapper that applies Material3 theming.
 *
 * @param content The composable content to be themed
 */
@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        content = content
    )
}
