package com.example.testing.domain

class CalculatorEngine {

    private var currentValue: String = "0"

    // Propiedad que puedes exponer para obtener el resultado actual
    val displayValue: String
        get() = currentValue

    // Ejemplo de método para procesar entradas de dígitos, operadores, etc.
    fun processInput(input: String) {
        // Lógica para concatenar dígitos, detectar operadores, etc.
        if (currentValue == "0" && input in listOf("0","1","2","3","4","5","6","7","8","9")) {
            currentValue = input
        } else {
            currentValue += input
        }
    }

    fun clear() {
        currentValue = "0"
    }

    // ... más funciones para manejar +, -, *, /, y otras operaciones
    fun calculate() {
        // Aquí podrías implementar la lógica de evaluación
    }
}