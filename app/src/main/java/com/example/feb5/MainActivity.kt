package com.example.feb5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InflationCalculatorScreen()
        }
    }
}


@Composable
fun InflationCalculatorScreen() {




    var basePrice by remember { mutableStateOf("") }



    // Food inflation %
    val inflationRate = 7.71


    val inflatedPrice = basePrice.toDoubleOrNull()?.let {
        it + (it * inflationRate / 100)
    } ?: 0.0

    //AKN KAR DINERR 11 TK HOLO AGER 10 TK ER MAAN



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Food Inflation Calculator",
            style = MaterialTheme.typography.headlineMedium
        )

        OutlinedTextField(
            value = basePrice,
            onValueChange = { basePrice = it },
            label = { Text("Enter food price (Tk)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "Inflation Rate: $inflationRate%",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "New Price: ৳${String.format("%.2f", inflatedPrice)}",
            style = MaterialTheme.typography.titleLarge,
            color = Color(0xFF2E7D32) // Green shade
        )
    }
}











//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun GreetingPreview() {
//
//
//    InflationCalculatorScreen()
//
//
//}