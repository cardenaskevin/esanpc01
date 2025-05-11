package com.example.esancardenaspc01

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

data class Producto(val nombre: String, val precio: Double, val categoria: String, val imagenUrl: String)

val productos = listOf(
    Producto("Laptop Lenovo", 2800.0, "Laptop", "https://..."),
    Producto("iPhone 14", 4000.0, "Smartphone", "https://..."),
    Producto("Auriculares", 120.0, "Accesorio", "https://...")
)

@Composable
fun CatalogoProductosScreen(navController: NavHostController) {
    val total = productos.sumOf { it.precio }

    LazyColumn {
        items(productos) { prod ->
            Card(modifier = Modifier.padding(8.dp)) {
                Row {
                    AsyncImage(model = prod.imagenUrl, contentDescription = null, modifier = Modifier.size(80.dp))
                    Column {
                        Text(prod.nombre)
                        Text("S/ ${prod.precio}")
                        Text(prod.categoria)
                    }
                }
            }
        }
        item {
            Text("Total: S/ ${"%.2f".format(total)}", style = MaterialTheme.typography.titleMedium)
            Button(onClick = { navController.popBackStack() }) {
                Text("Volver al menú")
            }
        }
    }
}

@Composable
fun AsyncImage(model: Any, contentDescription: Nothing?, modifier: Any) {
    TODO("Not yet implemented")
}


