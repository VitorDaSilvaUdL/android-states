package com.example.testing.ui.view

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Colorize
import androidx.compose.material.icons.filled.Computer
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.testing.ui.viewmodel.CounterViewModel

// Enum para representar el modo seleccionado
enum class ScreenMode {
    BASIC, COUNTER, COUNTER_VM
}

@Composable
fun CalculatorApp(navController: NavController) {
    // Estado que guarda el modo actual
   var selectedMode by remember { mutableStateOf(ScreenMode.COUNTER) }

//    var selectedMode = ScreenMode.BASIC;

    Scaffold(
        bottomBar = {
            NavigationBar {
//                NavigationBarItem(
//                    icon = { Icon(Icons.Default.Menu, contentDescription = "Básica") },
//                    selected = selectedMode == ScreenMode.BASIC,
//                    onClick = { selectedMode = ScreenMode.BASIC },
//                    label = { Text("Básica") }
//                )

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
                    icon = { Icon(Icons.Default.Computer, contentDescription = "Counter VM") },
                    selected = selectedMode == ScreenMode.COUNTER_VM,
                    onClick = { selectedMode = ScreenMode.COUNTER_VM },
                    label = { Text("COUNTER VM") }
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
                ScreenMode.COUNTER -> Counter()
                ScreenMode.COUNTER_VM -> CounterWithViewModel()
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
fun Counter() {
    // Vista placeholder para la calculadora de IMC
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Contador", style = MaterialTheme.typography.headlineMedium )

        CounterButton()

    }
}


@Composable
fun CounterButton() {

    //Replace
    //var count = 0

    //with
    var count by remember { mutableStateOf(0)}



    Button(onClick = {
        count += 1				 			// count = count + 1
        Log.d("Counter", "Count: $count")
    },
        shape = CircleShape,
        modifier = Modifier
            .height(150.dp)
            .width(150.dp)) {
        Text(text = "Tap $count", fontSize = 30.sp,
            fontWeight = FontWeight.Bold)
    }
}


@Composable
fun CounterWithViewModel(
    counterViewModel: CounterViewModel = viewModel()
) {
    // Estado actual del contador desde el ViewModel
    val count = counterViewModel.count

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Contador (ViewModel)",
            style = MaterialTheme.typography.headlineMedium
        )

        Button(
            onClick = { counterViewModel.increment() },
            shape = CircleShape,
            modifier = Modifier
                .height(150.dp)
                .width(150.dp)
        ) {
            Text(
                text = "Tap $count",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}