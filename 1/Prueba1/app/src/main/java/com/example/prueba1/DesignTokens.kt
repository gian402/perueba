package com.example.prueba1

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.border
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Design tokens object containing all color and dimension constants
 * used throughout the application for consistent styling.
 */
object DesignTokens {
    // region Color Tokens
    /** White background color */
    val colorWhite: Color = Color(0xFFFFFFFF)
    
    /** Cyan/Deep sky blue color for circles */
    val colorCyan: Color = Color(0xFF00D4FF)
    
    /** Semi-transparent gray for circle borders */
    val colorCircleBorder: Color = Color(0x33000000)
    
    /** Deep indigo/purple color */
    val colorIndigo: Color = Color(0xFF4B0082)
    
    /** Royal blue color */
    val colorRoyalBlue: Color = Color(0xFF0077FF)
    
    /** Blue violet/purple color */
    val colorBlueViolet: Color = Color(0xFF8A2BE2)
    // endregion
}
