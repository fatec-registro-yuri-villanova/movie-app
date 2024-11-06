package com.fatec.cineapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.fatec.cineapp.core.presentation.MainScreen
import com.fatec.cineapp.ui.theme.CineAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val apiKey = BuildConfig.API_KEY
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CineAppTheme {
                MainScreen(navController = rememberNavController())
            }
        }
    }
}

