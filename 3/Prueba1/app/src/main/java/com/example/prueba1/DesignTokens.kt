package com.example.prueba1

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Global design tokens used across the application.
 * Contains color, spacing, typography, and dimension constants.
 */
object DesignTokens {
    // region Color Tokens
    val colorWhite = Color(0xFFFFFFFF)
    val colorPrimaryDark = Color(0xFF4B0082)
    val colorTextSecondary = Color(0xFF757575)
    val colorTextPrimary = Color(0xFF2C2C2C)
    val colorTextDark = Color(0xFF1E1E1E)
    val colorOverlay = Color(0x33000000)
    val colorAccentCyan = Color(0xFF00D4FF)
    val colorAccentBlue = Color(0xFF0077FF)
    val colorBorder = Color(0xFFD9D9D9)
    val colorPlaceholder = Color(0xFFB3B3B3)
    val colorSurface = Color(0xFF303030)
    val colorBackground = Color(0xFFF5F5F5)
    val colorAccentPurple = Color(0xFF8A2BE2)
    // endregion

    // region Typography
    val fontSizeBody = 16.sp
    // endregion

    // region Spacing
    val spacingSmall = 8.dp
    val spacingMedium = 12.dp
    val spacingLarge = 16.dp
    val spacingXLarge = 24.dp
    // endregion

    // region Corner Radius
    val cornerRadiusSmall = 8.dp
    val cornerRadiusMedium = 12.dp
    val cornerRadiusLarge = 20.dp
    // endregion

    // region Border Width
    val borderWidthDefault = 1.dp
    // endregion
}