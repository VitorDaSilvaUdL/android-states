package com.example.testing.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testing.domain.model.CalculatorEngine


@Composable
fun BasicCalculatorUI() {
    var displayText by remember { mutableStateOf("0") }
    var calculatorEngine by remember {  mutableStateOf(CalculatorEngine()) }

    // Función para manejar la pulsación de botones
    fun onButtonClick(input: String) {

        calculatorEngine.processInput(input)
        displayText = calculatorEngine.displayValue

//        when (input) {
//            "C" -> displayText = "0"
//            "=" -> {
//                // Aquí podrías evaluar la expresión. Por simplicidad no se implementa.
//                // Por ejemplo, podrías usar una función de evaluación o una librería de scripting.
//            }
//            else -> {
//                displayText = if (displayText == "0") input else displayText + input
//            }
//        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Pantalla de visualización
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(MaterialTheme.colorScheme.primaryContainer, shape = MaterialTheme.shapes.medium)
                .padding(16.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                text = displayText,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }

        // Definición de las filas de botones
        val buttons = listOf(
            listOf("%", "x²", "1/x", "<<"),
            listOf("7", "8", "9", "÷"),
            listOf("4", "5", "6", "x"),
            listOf("1", "2", "3", "-"),
            listOf("C", "0", "=", "+")
        )

        // Construcción del teclado en grilla
        buttons.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                row.forEach { label ->
                    Button(
                        onClick = { onButtonClick(label) },
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f) // Asegura que el botón sea cuadrado
                    ) {
                        Text(text = label, style = MaterialTheme.typography.titleLarge)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ShowBasic(){
    BasicCalculatorUI()
}
