package com.example.esancardenaspc01

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController



@Composable
fun Navgraph(navController: NavHostController) {
    NavHost(navController, startDestination = "menu") {
        composable("menu") { MenuScreen(navController) }
        composable("edad_canina") { EdadCaninaScreen(navController) }
        composable("divisas") { ConversorDivisasScreen(navController) }
        composable("catalogo") { CatalogoProductosScreen(navController) }
    }
}

