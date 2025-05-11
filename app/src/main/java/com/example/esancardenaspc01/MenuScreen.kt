package com.example.esancardenaspc01

import android.widget.Button
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import org.w3c.dom.Text


@Composable
fun MenuScreen(navController: NavHostController) {
    Column {
        Button(onClick = { navController.navigate("edad_canina") }) {
            Text("Calculadora de Edad Canina")
        }
        Button(onClick = { navController.navigate("divisas") }) {
            Text("Conversor de Divisas")
        }
        Button(onClick = { navController.navigate("catalogo") }) {
            Text("Catálogo de Productos Tecnológicos")
        }
    }
}


