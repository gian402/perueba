package com.novatec.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

// Colores del diseño
object NovaTecColors {
    val primary = Color(0xFF00D4FF)  // Cyan
    val secondary = Color(0xFFB800FF) // Púrpura
    val dark = Color(0xFF2C2C2C)
    val lightGray = Color(0xFFB3B3B3)
    val border = Color(0xFFD9D9D9)
    val white = Color.White
}

// Tipografía
val InterFont = FontFamily(Font(R.font.inter_regular))

@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(NovaTecColors.white)
    ) {
        // Fondo decorativo con círculos (elipses)
        BackgroundDecorations()

        // Contenido principal
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            // Logo NovaTec
            LogoSection()

            Spacer(modifier = Modifier.height(60.dp))

            // Formulario de Login
            LoginForm(
                email = email,
                password = password,
                onEmailChange = { email = it },
                onPasswordChange = { password = it }
            )

            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Composable
fun LogoSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.size(212.dp)
    ) {
        // Aquí irá la imagen del logo
        // AsyncImage(
        //     model = "https://your-asset-url.com/logo.png",
        //     contentDescription = "NovaTec Logo",
        //     modifier = Modifier.size(212.dp),
        //     contentScale = ContentScale.Fit
        // )

        // Por ahora un placeholder
        Box(
            modifier = Modifier
                .size(212.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(
                    brush = androidx.compose.ui.graphics.Brush.linearGradient(
                        colors = listOf(NovaTecColors.primary, NovaTecColors.secondary)
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "N",
                fontSize = 80.sp,
                color = NovaTecColors.white,
                fontFamily = InterFont
            )
        }
    }
}

@Composable
fun LoginForm(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp)),
        colors = CardDefaults.cardColors(containerColor = NovaTecColors.white),
        border = androidx.compose.material3.CardDefaults.outlinedCardBorder()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Campo de Correo
            InputFieldComponent(
                label = "Correo",
                value = email,
                onValueChange = onEmailChange,
                keyboardType = KeyboardType.Email
            )

            // Campo de Contraseña
            InputFieldComponent(
                label = "Contraseña",
                value = password,
                onValueChange = onPasswordChange,
                keyboardType = KeyboardType.Password,
                isPassword = true
            )

            // Botón Sign In
            SignInButton()

            // Link Olvidaste contraseña
            ForgotPasswordLink()
        }
    }
}

@Composable
fun InputFieldComponent(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPassword: Boolean = false
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = label,
            fontSize = 16.sp,
            color = NovaTecColors.dark,
            fontFamily = InterFont
        )

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    text = "Value",
                    color = NovaTecColors.lightGray,
                    fontFamily = InterFont
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            visualTransformation = if (isPassword) PasswordVisualTransformation() else androidx.compose.ui.text.input.VisualTransformation.None,
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = NovaTecColors.primary,
                unfocusedBorderColor = NovaTecColors.border,
                focusedLabelColor = NovaTecColors.primary
            ),
            singleLine = true,
            textStyle = TextStyle(fontSize = 16.sp, fontFamily = InterFont)
        )
    }
}

@Composable
fun SignInButton() {
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(containerColor = NovaTecColors.dark),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = "Sign In",
            fontSize = 16.sp,
            color = Color(0xFFF5F5F5),
            fontFamily = InterFont
        )
    }
}

@Composable
fun ForgotPasswordLink() {
    Text(
        text = "Olvidaste tu contraseña?",
        fontSize = 16.sp,
        color = NovaTecColors.dark,
        fontFamily = InterFont,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    )
}

@Composable
fun BackgroundDecorations() {
    // Esta función dibuja los círculos decorativos del fondo
    // Los círculos están posicionados de forma absoluta en el fondo
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Los círculos se renderizarían aquí
        // Por ahora usamos un fondo gradiente simple
    }
}

@Composable
fun rememberScrollState(): androidx.compose.foundation.ScrollState {
    return remember { androidx.compose.foundation.ScrollState(0) }
}
