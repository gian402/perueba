package com.novatec.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

val CyanCircle = Color(0xFF00D4FF)
val PurpleCircle = Color(0xFF7B2FBE)
val DarkPurple = Color(0xFF3D1A6E)

@Composable
fun SplashScreen(onFinished: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(2000)
        onFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkPurple)
    ) {
        // Círculo cyan top-center (grande)
        Box(
            modifier = Modifier
                .offset(x = 30.dp, y = (-60).dp)
                .size(260.dp)
                .clip(CircleShape)
                .background(CyanCircle)
        )
        // Círculo púrpura medio-izquierda
        Box(
            modifier = Modifier
                .offset(x = (-40).dp, y = 180.dp)
                .size(240.dp)
                .clip(CircleShape)
                .background(Color(0xFF9B4FD0))
        )
        // Círculo púrpura medio-derecha
        Box(
            modifier = Modifier
                .offset(x = 160.dp, y = 200.dp)
                .size(220.dp)
                .clip(CircleShape)
                .background(Color(0xFF7B2FBE))
        )
        // Círculo cyan inferior-centro
        Box(
            modifier = Modifier
                .offset(x = 20.dp, y = 430.dp)
                .size(260.dp)
                .clip(CircleShape)
                .background(CyanCircle)
        )
        // Círculo púrpura inferior-izquierda
        Box(
            modifier = Modifier
                .offset(x = (-30).dp, y = 600.dp)
                .size(200.dp)
                .clip(CircleShape)
                .background(Color(0xFF9B4FD0))
        )
        // Círculo cyan inferior-derecha
        Box(
            modifier = Modifier
                .offset(x = 200.dp, y = 580.dp)
                .size(180.dp)
                .clip(CircleShape)
                .background(CyanCircle)
        )
    }
}
