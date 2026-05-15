package com.example.prueba1

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.prueba1.ui.theme.AppTheme
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.*
import androidx.compose.runtime.remember

// region Circle Data
/**
 * Data class representing a decorative circle with position and color.
 *
 * @param offsetX Horizontal offset from the start position
 * @param offsetY Vertical offset from the top position
 * @param size Diameter of the circle
 * @param color Background color of the circle
 */
data class CircleData(
    val offsetX: Dp,
    val offsetY: Dp,
    val size: Dp,
    val color: Color
)
// endregion

// region Modifier Extensions
/**
 * Modifier extension for applying consistent circle styling with shadow and border.
 */
fun Modifier.decorativeCircleStyle(
    size: Dp,
    color: Color
): Modifier = this
    .size(size)
    .shadow(
        elevation = 20.dp,
        shape = CircleShape,
        ambientColor = Color(0x59000000),
        spotColor = Color(0x59000000)
    )
    .clip(CircleShape)
    .border(
        width = 1.dp,
        color = DesignTokens.colorCircleBorder,
        shape = CircleShape
    )
    .background(color, shape = CircleShape)
// endregion

// region Decorative Circle Component
/**
 * A single decorative circle composable used in the colorful circles screen.
 *
 * @param circleData Data containing position, size, and color of the circle
 * @param modifier Optional modifier for additional styling
 */
@Composable
fun DecorativeCircle(
    circleData: CircleData,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .offset(x = circleData.offsetX, y = circleData.offsetY)
            .decorativeCircleStyle(
                size = circleData.size,
                color = circleData.color
            )
    )
}
// endregion

// region Colorful Circles Screen
/**
 * Main screen displaying a collection of colorful overlapping circles.
 * This creates a vibrant, decorative background pattern with circles
 * in various shades of blue, purple, and cyan.
 *
 * @param modifier Optional modifier for the root composable
 */
@Composable
fun ColorfulCirclesScreen(
    modifier: Modifier = Modifier
) {
    val circleSize = 359.dp
    
    val circles = listOf(
        // Top row - Cyan circles
        CircleData(offsetX = (-80).dp, offsetY = (-50).dp, size = circleSize, color = DesignTokens.colorCyan),
        CircleData(offsetX = 100.dp, offsetY = (-30).dp, size = circleSize, color = DesignTokens.colorRoyalBlue),
        
        // Second row - Indigo circles
        CircleData(offsetX = (-60).dp, offsetY = 150.dp, size = circleSize, color = DesignTokens.colorIndigo),
        CircleData(offsetX = 120.dp, offsetY = 180.dp, size = circleSize, color = DesignTokens.colorIndigo),
        
        // Third row - Blue Violet circles
        CircleData(offsetX = (-40).dp, offsetY = 380.dp, size = circleSize, color = DesignTokens.colorBlueViolet),
        CircleData(offsetX = 140.dp, offsetY = 400.dp, size = circleSize, color = DesignTokens.colorBlueViolet),
        
        // Fourth row - Royal Blue circles
        CircleData(offsetX = (-70).dp, offsetY = 600.dp, size = circleSize, color = DesignTokens.colorRoyalBlue),
        CircleData(offsetX = 110.dp, offsetY = 620.dp, size = circleSize, color = DesignTokens.colorRoyalBlue),
        
        // Fifth row - Cyan circles
        CircleData(offsetX = (-50).dp, offsetY = 820.dp, size = circleSize, color = DesignTokens.colorCyan),
        CircleData(offsetX = 130.dp, offsetY = 850.dp, size = circleSize, color = DesignTokens.colorCyan),
        
        // Bottom row - Blue Violet circles
        CircleData(offsetX = (-60).dp, offsetY = 1050.dp, size = circleSize, color = DesignTokens.colorBlueViolet),
        CircleData(offsetX = 120.dp, offsetY = 1080.dp, size = circleSize, color = DesignTokens.colorBlueViolet)
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(DesignTokens.colorIndigo)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(width = 402.dp, height = 1400.dp)
            ) {
                circles.forEach { circleData ->
                    DecorativeCircle(circleData = circleData)
                }
            }
        }
    }
}
// endregion

@Preview(showBackground = true)
@Composable
fun ColorfulCirclesScreenPreview() {
    AppTheme {
        ColorfulCirclesScreen()
    }
}
