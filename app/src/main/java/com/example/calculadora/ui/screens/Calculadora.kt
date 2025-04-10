package com.example.calculadora.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculadora.ui.components.CustomTopAppBar
import com.example.calculadora.ui.components.CustomButton


@Composable
fun Calculadora() {
    var numero1 by remember { mutableStateOf("") }
    var numero2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("Selecione uma operação ou digite os números corretamente.") }
    var operacao by remember { mutableIntStateOf(0) }


    Scaffold(topBar = {
        CustomTopAppBar()
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = resultado, modifier = Modifier.fillMaxWidth(), style = MaterialTheme.typography.titleMedium, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(50.dp))
            OutlinedTextField(
                value = numero1,
                onValueChange = { numero1 = it },
                label = { Text("Digite um número") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = numero2,
                onValueChange = { numero2 = it },
                label = { Text("Digite outro número...") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Column(
                modifier = Modifier
                    .padding(innerPadding),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CustomButton(
                        onClick = {operacao = 1},
                        selected = operacao == 1,
                        buttonText = "Somar"
                    )
                    CustomButton(
                        onClick = {operacao = 2},
                        selected = operacao == 2,
                        buttonText = "Subtrair"
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CustomButton(
                        onClick = {operacao = 3},
                        selected = operacao == 3,
                        buttonText = "Dividir"
                    )
                    CustomButton(
                        onClick = {operacao = 4},
                        selected = operacao == 4,
                        buttonText = "Multiplicar"
                    )
                }
            }
            Spacer(modifier = Modifier.height(50.dp))
            CustomButton(onClick = {
                resultado = calcular(
                    numero1.toFloatOrNull(),
                    numero2.toFloatOrNull(),
                    operacao
                )
            }, "Calcular", true)
        }
    }
}

fun calcular(numero1: Float?, numero2: Float?, operacao: Int): String {
    var resultado: String = ""
    if (numero1 == null || numero2 == null || operacao == 0) {
        return "Selecione uma operação ou digite os números corretamente."
    }

    when (operacao) {
        1 -> resultado = (numero1 + numero2).toString()
        2 -> resultado = (numero1 - numero2).toString()
        3 -> resultado = (numero1 / numero2).toString()
        4 -> resultado = (numero1 * numero2).toString()
        else -> println("Não foi possível realizar as operações.")
    }
    return resultado
}


@Preview(showBackground = true)
@Composable
fun CalculadoraPreview() {
    Calculadora()
}