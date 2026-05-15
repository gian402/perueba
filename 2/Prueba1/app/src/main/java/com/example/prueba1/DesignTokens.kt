package com.example.prueba1

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Design tokens for consistent styling across the application.
 * Contains color definitions and dimension values.
 */
object DesignTokens {
    // region Color Tokens
    val colorWhite: Color = Color(0xFFFFFFFF)
    // endregion

    // region Dimension Tokens
    val logoSize = 300.dp
    // endregion
}
