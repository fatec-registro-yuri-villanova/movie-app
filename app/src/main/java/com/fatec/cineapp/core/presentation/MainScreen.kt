package com.fatec.cineapp.core.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    navController: NavHostController
) {
    Scaffold(
        Modifier.padding(top = 16.dp),
        content = {
            Text("Main Screen")
        }
    )
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen(navController = rememberNavController())
}