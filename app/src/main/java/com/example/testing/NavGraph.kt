package com.example.testing


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testing.ui.view.LoginScreen
import com.example.testing.ui.view.CalculatorApp

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("login") { LoginScreen(navController) }
        composable("home") { CalculatorApp(navController) }
    }
}