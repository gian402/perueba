package com.novatec.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.novatec.app.R

// Aliases para uso en LoginScreen
val Cyan = PrimaryCyan
val Purple = PrimaryPurple
val Dark = DarkColor
val Border = BorderGray

val InterFamily = FontFamily(Font(R.font.inter_regular))

private val ColorScheme = lightColorScheme(
    primary = PrimaryCyan,
    secondary = PrimaryPurple,
    onPrimary = Color.White,
    background = Color.White,
    surface = Color.White,
)

@Composable
fun NovaTecTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = ColorScheme, content = content)
}
