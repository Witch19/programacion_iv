package com.ute.hellojetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Colors : Screen("colors")
    object Math : Screen("math")
}

class MainAreaTriangulo : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { BasicNavApp() }
    }
}

@Composable
fun BasicNavApp() {
    val nav = rememberNavController()
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            NavHost(navController = nav, startDestination = Screen.Home.route) {
                composable(route = Screen.Home.route) { HomeScreen(nav) }
                composable(route = Screen.Colors.route) { ColorScreen(nav) }
                composable(route = Screen.Math.route) { MathScreen(nav) }
            }
        }
    }
}

@Composable
fun HomeScreen(nav: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Ejemplos de Navegación",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(20.dp))

        Button(
            onClick = { nav.navigate(Screen.Colors.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cambiar color de fondo")
        }

        Spacer(Modifier.height(12.dp))

        Button(
            onClick = { nav.navigate(Screen.Math.route) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ejercicios Matemáticos")
        }
    }
}

@Composable
fun ColorScreen(nav: NavController) {
    var bg by remember { mutableStateOf(Color(0xFFC0C0C0)) }
    var current by remember { mutableStateOf("Azul oscuro") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bg)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                "Pantalla de Colores",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(12.dp))
            Text("Color actual: $current", color = Color.White)
        }

        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = { bg = Color(0xFF000000); current = "Negro" }) { Text("Negro") }
                Button(onClick = { bg = Color(0xFF800000); current = "Marrón" }) { Text("Marrón") }
                Button(onClick = { bg = Color(0xFF808000); current = "Oliva" }) { Text("Oliva") }
            }

            Spacer(Modifier.height(12.dp))
            Button(onClick = { nav.navigateUp() }, modifier = Modifier.fillMaxWidth()) {
                Text("Volver")
            }
        }
    }
}

@Composable
fun MathScreen(nav: NavController) {
    var radio by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var discount by remember { mutableStateOf("") }

    val area = triangleArea(radio)
    val (finalPrice, saved) = discountCalc(price, discount)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            "Ejercicios Matemáticos",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("Área del Círculo", fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    value = radio,
                    onValueChange = { radio = it },
                    label = { Text("Radio") }
                )
                Text("Área = ${"%.2f".format(area)}")
            }
        }

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("Descuento", fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    value = price,
                    onValueChange = { price = it },
                    label = { Text("Precio") }
                )
                OutlinedTextField(
                    value = discount,
                    onValueChange = { discount = it },
                    label = { Text("Descuento %") }
                )
                Text("Precio final = ${"%.2f".format(finalPrice)}")
                Text("Ahorro = ${"%.2f".format(saved)}")
            }
        }

        Button(onClick = { nav.navigateUp() }, modifier = Modifier.fillMaxWidth()) {
            Text("Volver")
        }
    }
}

fun triangleArea(radio: String): Double {
    val r = radio.replace(",", ".").toDoubleOrNull() ?: 0.0
    return (3.14159 * (r * r))
}

fun discountCalc(price: String, discount: String): Pair<Double, Double> {
    val p = price.replace(",", ".").toDoubleOrNull() ?: 0.0
    val d = discount.replace(",", ".").toDoubleOrNull() ?: 0.0
    val saved = p * (d / 100)
    val final = p - saved
    return final to saved
}

@Preview(showBackground = true)
@Composable
fun PreviewNav() {
    BasicNavApp()
}
