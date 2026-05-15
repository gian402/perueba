package com.novatec.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.novatec.app.ui.screens.LoginScreen
import com.novatec.app.ui.screens.LogoScreen
import com.novatec.app.ui.screens.SplashScreen
import com.novatec.app.ui.theme.NovaTecTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NovaTecTheme {
                var screen by remember { mutableStateOf("splash") }
                when (screen) {
                    "splash" -> SplashScreen(onFinished = { screen = "logo" })
                    "logo"   -> LogoScreen(onFinished = { screen = "login" })
                    "login"  -> LoginScreen()
                }
            }
        }
    }
}
