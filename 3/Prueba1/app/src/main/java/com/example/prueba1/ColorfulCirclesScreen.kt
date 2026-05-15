package com.example.prueba1

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.prueba1.ui.theme.AppTheme

private val Cyan = Color(0xFF00D4FF)
private val Indigo = Color(0xFF4B0082)
private val RoyalBlue = Color(0xFF0077FF)
private val BlueViolet = Color(0xFF8A2BE2)
private val CircleBorder = Color(0x33000000)

data class CircleData(val offsetX: Dp, val offsetY: Dp, val size: Dp, val color: Color)

@Composable
fun ColorfulCirclesScreen(modifier: Modifier = Modifier) {
    val circleSize = 359.dp
    val circles = listOf(
        CircleData((-80).dp, (-50).dp, circleSize, Cyan),
        CircleData(100.dp, (-30).dp, circleSize, RoyalBlue),
        CircleData((-60).dp, 150.dp, circleSize, Indigo),
        CircleData(120.dp, 180.dp, circleSize, Indigo),
        CircleData((-40).dp, 380.dp, circleSize, BlueViolet),
        CircleData(140.dp, 400.dp, circleSize, BlueViolet),
        CircleData((-70).dp, 600.dp, circleSize, RoyalBlue),
        CircleData(110.dp, 620.dp, circleSize, RoyalBlue),
        CircleData((-50).dp, 820.dp, circleSize, Cyan),
        CircleData(130.dp, 850.dp, circleSize, Cyan),
        CircleData((-60).dp, 1050.dp, circleSize, BlueViolet),
        CircleData(120.dp, 1080.dp, circleSize, BlueViolet),
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Indigo)
    ) {
        Box(modifier = Modifier.size(width = 402.dp, height = 1400.dp)) {
            circles.forEach { c ->
                Box(
                    modifier = Modifier
                        .offset(x = c.offsetX, y = c.offsetY)
                        .size(c.size)
                        .shadow(20.dp, CircleShape, ambientColor = Color(0x59000000), spotColor = Color(0x59000000))
                        .clip(CircleShape)
                        .border(1.dp, CircleBorder, CircleShape)
                        .background(c.color, CircleShape)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ColorfulCirclesScreenPreview() {
    AppTheme { ColorfulCirclesScreen() }
}
