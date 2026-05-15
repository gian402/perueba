package com.novatec.app.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.novatec.app.R
import com.novatec.app.ui.theme.*

@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(300)
        isVisible = true
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Fondo decorativo con elipses
        BackgroundDecorations()

        // Contenido principal con scroll
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 32.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            // Logo con animación
            LogoWithAnimation(isVisible)

            Spacer(modifier = Modifier.height(24.dp))

            // Título
            TitleText(isVisible)

            Spacer(modifier = Modifier.height(32.dp))

            // Formulario
            LoginFormCard(
                email = email,
                password = password,
                onEmailChange = { email = it },
                onPasswordChange = { password = it },
                isVisible = isVisible
            )

            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Composable
fun BackgroundDecorations() {
    Box(modifier = Modifier.fillMaxSize()) {
        // Elipse superior derecha (morada)
        Image(
            painter = painterResource(id = R.drawable.elipse_2),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.TopEnd)
                .graphicsLayer(alpha = 0.8f),
            contentScale = ContentScale.Crop
        )

        // Elipse inferior izquierda (cyan/morada)
        Image(
            painter = painterResource(id = R.drawable.elipse_1),
            contentDescription = null,
            modifier = Modifier
                .size(180.dp)
                .align(Alignment.BottomStart)
                .graphicsLayer(alpha = 0.7f),
            contentScale = ContentScale.Crop
        )

        // Elipse adicional central (decorativa)
        Image(
            painter = painterResource(id = R.drawable.elipse_2),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .align(Alignment.TopStart)
                .graphicsLayer(alpha = 0.6f),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun LogoWithAnimation(isVisible: Boolean) {
    var logoScale by remember { mutableStateOf(0.8f) }
    var logoAlpha by remember { mutableStateOf(0f) }

    LaunchedEffect(isVisible) {
        if (isVisible) {
            logoAlpha = 1f
            logoScale = 1f
        }
    }

    Image(
        painter = painterResource(id = R.drawable.novatec_logo),
        contentDescription = "NovaTec Logo",
        modifier = Modifier
            .size(160.dp)
            .graphicsLayer(
                scaleX = logoScale,
                scaleY = logoScale,
                alpha = logoAlpha
            )
            .animateContentSize(animationSpec = tween(800)),
        contentScale = ContentScale.Fit
    )
}

@Composable
fun TitleText(isVisible: Boolean) {
    var titleAlpha by remember { mutableStateOf(0f) }

    LaunchedEffect(isVisible) {
        if (isVisible) {
            titleAlpha = 1f
        }
    }

    Text(
        text = "Iniciar Sesión",
        style = TextStyle(
            fontFamily = InterFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            color = Dark
        ),
        modifier = Modifier
            .graphicsLayer(alpha = titleAlpha)
            .animateContentSize(animationSpec = tween(600))
    )
}

@Composable
fun LoginFormCard(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    isVisible: Boolean
) {
    var formAlpha by remember { mutableStateOf(0f) }
    var formScale by remember { mutableStateOf(0.95f) }

    LaunchedEffect(isVisible) {
        if (isVisible) {
            formAlpha = 1f
            formScale = 1f
        }
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .graphicsLayer(
                alpha = formAlpha,
                scaleX = formScale,
                scaleY = formScale
            )
            .animateContentSize(animationSpec = tween(1000)),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.5.dp, Border),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp,
            pressedElevation = 8.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Campo Email
            EmailInputField(email, onEmailChange)

            // Campo Contraseña
            PasswordInputField(password, onPasswordChange)

            // Link olvidaste contraseña
            ForgotPasswordLink()

            // Botón Sign In
            SignInButton()
        }
    }
}

@Composable
fun EmailInputField(email: String, onEmailChange: (String) -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
            text = "Correo",
            style = TextStyle(
                fontFamily = InterFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = Dark
            )
        )

        OutlinedTextField(
            value = email,
            onValueChange = onEmailChange,
            placeholder = { Text("tu@email.com", color = Border) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Cyan,
                unfocusedBorderColor = Border,
                focusedLabelColor = Cyan,
                cursorColor = Cyan,
                focusedTextColor = Dark,
                unfocusedTextColor = Dark
            ),
            textStyle = TextStyle(fontFamily = InterFamily)
        )
    }
}

@Composable
fun PasswordInputField(password: String, onPasswordChange: (String) -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
            text = "Contraseña",
            style = TextStyle(
                fontFamily = InterFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = Dark
            )
        )

        OutlinedTextField(
            value = password,
            onValueChange = onPasswordChange,
            placeholder = { Text("••••••••", color = Border) },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Cyan,
                unfocusedBorderColor = Border,
                focusedLabelColor = Cyan,
                cursorColor = Cyan,
                focusedTextColor = Dark,
                unfocusedTextColor = Dark
            ),
            textStyle = TextStyle(fontFamily = InterFamily)
        )
    }
}

@Composable
fun ForgotPasswordLink() {
    TextButton(
        onClick = { /* TODO: Navigate to forgot password */ },
        modifier = Modifier
            .align(Alignment.End)
            .padding(top = 8.dp)
    ) {
        Text(
            text = "¿Olvidaste tu contraseña?",
            style = TextStyle(
                fontFamily = InterFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 13.sp,
                color = Purple
            )
        )
    }
}

@Composable
fun SignInButton() {
    var isPressed by remember { mutableStateOf(false) }

    Button(
        onClick = { /* TODO: Perform login */ },
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .graphicsLayer(
                scaleX = if (isPressed) 0.95f else 1f,
                scaleY = if (isPressed) 0.95f else 1f
            ),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Dark,
            disabledContainerColor = Dark.copy(alpha = 0.6f)
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 4.dp,
            pressedElevation = 8.dp
        )
    ) {
        Text(
            text = "Sign In",
            style = TextStyle(
                fontFamily = InterFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = Color.White
            )
        )
    }
}
