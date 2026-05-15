package com.novatec.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.novatec.app.ui.screens.LoginScreen
import com.novatec.app.ui.theme.NovaTecTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NovaTecTheme {
                LoginScreen()
            }
        }
    }
}
