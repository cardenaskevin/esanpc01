package com.example.esancardenaspc01

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController

@Composable
fun EdadCaninaScreen(navController: NavHostController) {
    var edad by remember { mutableStateOf("") }
    var tamaño by remember { mutableStateOf("Pequeño") }
    var resultado by remember { mutableStateOf("") }
    val opciones = listOf("Pequeño", "Mediano", "Grande")

    Column {
        TextField(value = edad, onValueChange = { edad = it }, label = { Text("Edad del perro") })
        DropdownMenuBox(opciones, tamaño, { tamaño = it })
        Button(onClick = {
            val edadInt = edad.toIntOrNull()
            if (edadInt != null && edadInt > 0) {
                val edadPerro = when (tamaño) {
                    "Pequeño" -> edadInt * 5
                    "Mediano" -> edadInt * 6
                    else -> edadInt * 7
                }
                resultado = "¡Tu perro tiene $edadPerro años perro! 🐶"
            } else {
                resultado = "Ingresa una edad válida"
            }
        }) {
            Text("Calcular")
        }
        Text(resultado)
        Button(onClick = { navController.popBackStack() }) {
            Text("Volver al menú")
        }
    }
}
