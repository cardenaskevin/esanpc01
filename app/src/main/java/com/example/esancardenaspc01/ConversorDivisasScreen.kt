package com.example.esancardenaspc01

import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import org.w3c.dom.Text

@Composable
fun ConversorDivisasScreen(navController: NavHostController) {
    var monto by remember { mutableStateOf("") }
    var tipoCambio by remember { mutableStateOf("USD a PEN") }
    var resultado by remember { mutableStateOf("") }

    Column {
        TextField(value = monto, onValueChange = { monto = it }, label = { Text("Monto") })
        DropdownMenuBox(listOf("USD a PEN", "PEN a USD"), tipoCambio, { tipoCambio = it })
        Button(onClick = {
            val valor = monto.toDoubleOrNull()
            if (valor != null) {
                val tasa = 3.80
                resultado = when (tipoCambio) {
                    "USD a PEN" -> "S/ ${"%.2f".format(valor * tasa)}"
                    else -> "$ ${"%.2f".format(valor / tasa)}"
                }
            } else {
                resultado = "Monto inválido"
            }
        }) {
            Text("Convertir")
        }
        Text(resultado)
        Button(onClick = { navController.popBackStack() }) {
            Text("Volver al menú")
        }
    }
}


