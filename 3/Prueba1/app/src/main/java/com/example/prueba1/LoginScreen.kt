package com.example.prueba1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prueba1.ui.theme.AppTheme
import com.example.prueba1.ui.theme.inter
import androidx.compose.foundation.layout.width
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.scale

/**
 * Login screen composable that displays the NovaTec login form.
 * 
 * This screen contains:
 * - Company logo at the top
 * - Email input field
 * - Password input field
 * - Sign in button
 * - Forgot password link
 *
 * @param onSignInClick Callback invoked when the sign in button is clicked with email and password
 * @param onForgotPasswordClick Callback invoked when the forgot password link is clicked
 * @param modifier Optional modifier for the root composable
 */
@Composable
fun LoginScreen(
    onSignInClick: (email: String, password: String) -> Unit = { _, _ -> },
    onForgotPasswordClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isEmailError by remember { mutableStateOf(false) }
    var isPasswordError by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(LoginTokens.backgroundColor)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = LoginTokens.horizontalPadding)
    ) {
        Spacer(modifier = Modifier.height(LoginTokens.topSpacing))

        // region Logo Section
        LogoSection()
        // endregion

        Spacer(modifier = Modifier.height(LoginTokens.logoToFormSpacing))

        // region Login Form
        LoginFormCard(
            email = email,
            onEmailChange = { 
                email = it
                isEmailError = false
            },
            password = password,
            onPasswordChange = { 
                password = it
                isPasswordError = false
            },
            isEmailError = isEmailError,
            isPasswordError = isPasswordError,
            onSignInClick = {
                isEmailError = email.isBlank() || !email.contains("@")
                isPasswordError = password.isBlank()
                if (!isEmailError && !isPasswordError) {
                    onSignInClick(email, password)
                }
            },
            onForgotPasswordClick = onForgotPasswordClick
        )
        // endregion

        Spacer(modifier = Modifier.height(LoginTokens.bottomSpacing))
    }
}

/**
 * Displays the NovaTec company logo.
 */
@Composable
private fun LogoSection() {
    Image(
        painter = painterResource(R.drawable.novatec_logo),
        contentDescription = stringResource(R.string.logo_content_description),
        contentScale = ContentScale.Fit,
        modifier = Modifier.size(LoginTokens.logoSize)
    )
}

/**
 * Login form card containing email, password fields, sign in button and forgot password link.
 *
 * @param email Current email value
 * @param onEmailChange Callback when email changes
 * @param password Current password value
 * @param onPasswordChange Callback when password changes
 * @param isEmailError Whether to show email error state
 * @param isPasswordError Whether to show password error state
 * @param onSignInClick Callback when sign in is clicked
 * @param onForgotPasswordClick Callback when forgot password is clicked
 */
@Composable
private fun LoginFormCard(
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    isEmailError: Boolean,
    isPasswordError: Boolean,
    onSignInClick: () -> Unit,
    onForgotPasswordClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(LoginTokens.formFieldSpacing),
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = LoginTokens.cardBackgroundColor,
                shape = RoundedCornerShape(LoginTokens.cardCornerRadius)
            )
            .padding(LoginTokens.cardPadding)
    ) {
        // Email Field
        LoginInputField(
            label = stringResource(R.string.email_label),
            value = email,
            onValueChange = onEmailChange,
            placeholder = stringResource(R.string.email_placeholder),
            isError = isEmailError
        )

        // Password Field
        LoginInputField(
            label = stringResource(R.string.password_label),
            value = password,
            onValueChange = onPasswordChange,
            placeholder = stringResource(R.string.password_placeholder),
            isPassword = true,
            isError = isPasswordError
        )

        Spacer(modifier = Modifier.height(LoginTokens.fieldToButtonSpacing))

        // Sign In Button
        SignInButton(onClick = onSignInClick)

        // Forgot Password Link
        ForgotPasswordLink(onClick = onForgotPasswordClick)
    }
}

/**
 * Reusable input field for the login form.
 *
 * @param label Label text above the field
 * @param value Current field value
 * @param onValueChange Callback when value changes
 * @param placeholder Placeholder text
 * @param isPassword Whether this is a password field
 * @param isError Whether to show error state
 * @param modifier Optional modifier
 */
@Composable
private fun LoginInputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isPassword: Boolean = false,
    isError: Boolean = false,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(LoginTokens.labelToFieldSpacing),
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = label,
            color = LoginTokens.labelColor,
            style = TextStyle(
                fontSize = LoginTokens.labelFontSize,
                fontWeight = FontWeight.Normal,
                fontFamily = inter
            )
        )

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    text = placeholder,
                    color = LoginTokens.placeholderColor
                )
            },
            visualTransformation = if (isPassword) PasswordVisualTransformation() else androidx.compose.ui.text.input.VisualTransformation.None,
            isError = isError,
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = LoginTokens.inputBackgroundColor,
                unfocusedContainerColor = LoginTokens.inputBackgroundColor,
                focusedBorderColor = LoginTokens.inputBorderColor,
                unfocusedBorderColor = LoginTokens.inputBorderColor,
                errorBorderColor = Color.Red
            ),
            shape = RoundedCornerShape(LoginTokens.inputCornerRadius),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

/**
 * Sign in button component.
 *
 * @param onClick Callback when button is clicked
 */
@Composable
private fun SignInButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = LoginTokens.buttonBackgroundColor
        ),
        shape = RoundedCornerShape(LoginTokens.buttonCornerRadius),
        modifier = Modifier
            .fillMaxWidth()
            .height(LoginTokens.buttonHeight)
    ) {
        Text(
            text = stringResource(R.string.sign_in_button),
            color = LoginTokens.buttonTextColor,
            style = TextStyle(
                fontSize = LoginTokens.buttonFontSize,
                fontWeight = FontWeight.Medium,
                fontFamily = inter
            )
        )
    }
}

/**
 * Forgot password clickable text link.
 *
 * @param onClick Callback when link is clicked
 */
@Composable
private fun ForgotPasswordLink(onClick: () -> Unit) {
    Text(
        text = stringResource(R.string.forgot_password),
        color = LoginTokens.linkColor,
        style = TextStyle(
            fontSize = LoginTokens.linkFontSize,
            fontWeight = FontWeight.Normal,
            fontFamily = inter
        ),
        textDecoration = TextDecoration.Underline,
        modifier = Modifier.clickable { onClick() }
    )
}

/**
 * Design tokens specific to the Login screen.
 */
private object LoginTokens {
    // Colors
    val backgroundColor = Color(0xFFFFFFFF)
    val cardBackgroundColor = Color(0xFFFFFFFF)
    val labelColor = Color(0xFF1E1E1E)
    val placeholderColor = Color(0xFFB3B3B3)
    val inputBackgroundColor = Color(0xFFFFFFFF)
    val inputBorderColor = Color(0xFFD9D9D9)
    val buttonBackgroundColor = Color(0xFF2C2C2C)
    val buttonTextColor = Color(0xFFF5F5F5)
    val linkColor = Color(0xFF1E1E1E)

    // Dimensions
    val horizontalPadding = 24.dp
    val topSpacing = 80.dp
    val logoToFormSpacing = 60.dp
    val bottomSpacing = 100.dp
    val logoSize = 160.dp
    val cardPadding = 24.dp
    val cardCornerRadius = 8.dp
    val formFieldSpacing = 16.dp
    val labelToFieldSpacing = 8.dp
    val fieldToButtonSpacing = 8.dp
    val inputCornerRadius = 8.dp
    val buttonCornerRadius = 8.dp
    val buttonHeight = 48.dp

    // Typography
    val labelFontSize = 16.sp
    val buttonFontSize = 16.sp
    val linkFontSize = 16.sp
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    AppTheme {
        LoginScreen()
    }
}
