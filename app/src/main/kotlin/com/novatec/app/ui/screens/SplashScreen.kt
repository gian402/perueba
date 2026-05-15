package com.novatec.app.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import com.novatec.app.R
import com.novatec.app.ui.theme.*
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onNavigateToLogin: () -> Unit) {
    var logoScale by remember { mutableStateOf(0.5f) }
    var logoAlpha by remember { mutableStateOf(0f) }
    var titleAlpha by remember { mutableStateOf(0f) }
    var shouldNavigate by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        // Animar logo
        logoAlpha = 1f
        logoScale = 1f
        delay(500)
        
        // Mostrar título
        titleAlpha = 1f
        delay(2500)
        
        // Navegar a login
        shouldNavigate = true
    }

    if (shouldNavigate) {
        onNavigateToLogin()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        // Fondo decorativo con elipses
        SplashBackgroundDecorations()

        // Contenido del splash
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Logo animado
            Image(
                painter = painterResource(id = R.drawable.novatec_logo),
                contentDescription = "NovaTec Logo",
                modifier = Modifier
                    .size(260.dp)
                    .graphicsLayer(
                        scaleX = logoScale,
                        scaleY = logoScale,
                        alpha = logoAlpha
                    )
                    .animateContentSize(animationSpec = tween(1200)),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Texto NovaTec
            Text(
                text = "NovaTec",
                style = TextStyle(
                    fontFamily = InterFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    color = Cyan
                ),
                modifier = Modifier
                    .graphicsLayer(alpha = titleAlpha)
                    .animateContentSize(animationSpec = tween(1000))
            )

            Text(
                text = "App de Gestión",
                style = TextStyle(
                    fontFamily = InterFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = Dark
                ),
                modifier = Modifier
                    .graphicsLayer(alpha = titleAlpha)
                    .animateContentSize(animationSpec = tween(1000))
            )
        }
    }
}

@Composable
fun SplashBackgroundDecorations() {
    Box(modifier = Modifier.fillMaxSize()) {
        // Elipse superior derecha
        Image(
            painter = painterResource(id = R.drawable.elipse_2),
            contentDescription = null,
            modifier = Modifier
                .size(280.dp)
                .align(Alignment.TopEnd)
                .graphicsLayer(alpha = 0.7f),
            contentScale = ContentScale.Crop
        )

        // Elipse inferior izquierda
        Image(
            painter = painterResource(id = R.drawable.elipse_1),
            contentDescription = null,
            modifier = Modifier
                .size(260.dp)
                .align(Alignment.BottomStart)
                .graphicsLayer(alpha = 0.6f),
            contentScale = ContentScale.Crop
        )

        // Elipse inferior derecha
        Image(
            painter = painterResource(id = R.drawable.elipse_2),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.BottomEnd)
                .graphicsLayer(alpha = 0.5f),
            contentScale = ContentScale.Crop
        )
    }
}
