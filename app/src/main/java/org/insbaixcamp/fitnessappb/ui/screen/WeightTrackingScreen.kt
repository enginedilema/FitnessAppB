package org.insbaixcamp.fitnessappb.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.insbaixcamp.fitnessappb.FitnessApp
import org.insbaixcamp.fitnessappb.ui.theme.FitnessAppBTheme
import org.insbaixcamp.fitnessappb.utils.CalculadoraIMC

@Composable
fun WeightTrackingScreen(pes: Double, pesObjectiu: Double, alçada: Int) {
    var listPes = mutableListOf<Double>()
    var pesNou: Double by remember { mutableStateOf(0.0) }

    Column(Modifier.fillMaxHeight()) {
        Row(Modifier
            .fillMaxWidth()
            .padding(4.dp)) {
            Card(Modifier
                .padding(4.dp)
                .weight(1f)) {
                Column(modifier = Modifier
                    .padding(4.dp)
                    .wrapContentHeight()) {
                    Text("Pes actual")
                    Text("$pes Kg")
                }
            }
            Card(Modifier
                .padding(4.dp)
                .weight(1f)) {
                Column(modifier = Modifier
                    .padding(4.dp)
                    .wrapContentHeight()) {
                    Text("Pes objectiu")
                    Text("$pesObjectiu Kg")
                }
            }
            Card(Modifier
                .padding(4.dp)
                .weight(1f)) {
                Column(modifier = Modifier
                    .padding(4.dp)
                    .wrapContentHeight()) {
                    Text("IMC")
                    var imc = CalculadoraIMC.calcularIMC(pes, alçada)
                    Text("$imc ")
                }
            }
        }
        Text(
            text = "Registrar un nou pes",
            Modifier.padding(top = 16.dp)
        )
        OutlinedTextField(
            label = { Text(text = "Nou pes kg") },
            onValueChange = { pesNou = it.toDouble() },
            value = pes.toString(),
            modifier = Modifier.padding(8.dp).fillMaxWidth()
            )
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "Guardar pes")
        }
        Text(
            text = "Evolució del pes",
            Modifier.padding(top = 16.dp)
        )
        Card(modifier = Modifier.padding(8.dp)) {
            Box(modifier = Modifier.fillMaxWidth().height(150.dp))
        }
        Text(
            text = "Ultims registres",
            Modifier.padding(top = 16.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun TrackingScreenPreview() {
    FitnessAppBTheme {
        WeightTrackingScreen(70.0, 60.0, 170)
    }
}