package com.example.testing.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Colorize
import androidx.compose.material.icons.filled.Computer
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

// Enum para representar el modo seleccionado
enum class ScreenMode {
    BASIC, COUNTER, COLOR
}

@Composable
fun CalculatorApp(navController: NavController) {
    // Estado que guarda el modo actual
   var selectedMode by remember { mutableStateOf(ScreenMode.BASIC) }

//    var selectedMode = ScreenMode.BASIC;

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Menu, contentDescription = "Básica") },
                    selected = selectedMode == ScreenMode.BASIC,
                    onClick = { selectedMode = ScreenMode.BASIC },
                    label = { Text("Básica") }
                )
                //iconos
                //https://fonts.google.com/icons
                //https://developer.android.com/reference/kotlin/androidx/compose/material/icons/package-summary
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Computer, contentDescription = "Counter") },
                    selected = selectedMode == ScreenMode.COUNTER,
                    onClick = { selectedMode = ScreenMode.COUNTER },
                    label = { Text("COUNTER") }
                )

                NavigationBarItem(
                    icon = { Icon(Icons.Default.Colorize, contentDescription = "Button") },
                    selected = selectedMode == ScreenMode.COLOR,
                    onClick = { selectedMode = ScreenMode.COLOR },
                    label = { Text("COLOR") }
                )
            }
        }
    ) { innerPadding ->
        // Contenido que se actualiza según el modo seleccionado
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (selectedMode) {
                ScreenMode.BASIC -> BasicCalculator()
                ScreenMode.COUNTER -> IMCCalculator()
                ScreenMode.COLOR -> IMCCalculator()
            }
        }
    }
}

@Composable
fun BasicCalculator() {
    // Vista placeholder para la calculadora básica
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Calculadora Básica", style = MaterialTheme.typography.headlineMedium )
        // Aquí puedes agregar los componentes y lógica de la calculadora básica

        BasicCalculatorUI()
    }
}

@Composable
fun IMCCalculator() {
    // Vista placeholder para la calculadora de IMC
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Calculadora de IMC", style = MaterialTheme.typography.headlineMedium )
        // Aquí puedes agregar los componentes y lógica de la calculadora básica


    }
}