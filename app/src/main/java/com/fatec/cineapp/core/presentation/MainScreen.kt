package com.fatec.cineapp.core.presentation

import BottomNavigationBar
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.fatec.cineapp.core.presentation.navigation.NavigationGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    navController: NavHostController
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        },
        content = {
            NavigationGraph(
                navController = navController
            )
        }
    )
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen(navController = rememberNavController())
}