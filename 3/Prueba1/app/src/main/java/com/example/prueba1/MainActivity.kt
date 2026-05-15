package com.example.prueba1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.prueba1.ui.theme.AppTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var screen by remember { mutableStateOf("circles") }

                    LaunchedEffect(Unit) {
                        delay(2000)
                        screen = "logo"
                        delay(2000)
                        screen = "login"
                    }

                    when (screen) {
                        "circles" -> ColorfulCirclesScreen()
                        "logo"    -> SplashScreen()
                        "login"   -> LoginScreen()
                    }
                }
            }
        }
    }
}
