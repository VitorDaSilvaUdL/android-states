package com.example.testing.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    // Estado del contador con Compose
    var count by mutableStateOf(0)
        private set

    // Lógica de negocio: incrementar el valor del contador
    fun increment() {
        count++
    }
}
