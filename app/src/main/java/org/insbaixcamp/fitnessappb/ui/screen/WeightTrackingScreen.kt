package org.insbaixcamp.fitnessappb.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.insbaixcamp.fitnessappb.data.WeightTracking
import org.insbaixcamp.fitnessappb.ui.component.WeightTrackingItem
import org.insbaixcamp.fitnessappb.ui.theme.FitnessAppBTheme
import org.insbaixcamp.fitnessappb.utils.CalculadoraIMC

@Composable
fun WeightTrackingScreen(pes: Double, pesObjectiu: Double, alçada: Int) {
    val TAG = "WeightTrackingScreen"
    val listPes = remember { mutableStateListOf<WeightTracking>() }

    var _pes: Double by remember { mutableStateOf(pes) }
    var pesInputText by remember { mutableStateOf(pes.toString()) }

    Column(Modifier.fillMaxHeight()) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .wrapContentHeight()
        ) {
            Card(
                Modifier
                    .padding(4.dp)
                    .weight(1f)
            ) {
                Column(
                    modifier = Modifier
                        .padding(4.dp)
                        .wrapContentHeight()
                ) {
                    Text("Pes actual")
                    Text("$_pes Kg", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
            }
            Card(
                Modifier
                    .padding(4.dp)
                    .weight(1f)
            ) {
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .wrapContentHeight()
                ) {
                    Text("Pes objectiu")
                    Text("$pesObjectiu Kg", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
            }
            Card(
                Modifier
                    .padding(4.dp)
                    .weight(1f)
            ) {
                Column(
                    modifier = Modifier
                        .padding(4.dp)
                        .wrapContentHeight()
                ) {
                    Text("IMC")
                    val imc = CalculadoraIMC.calcularIMC(_pes, alçada)
                    Text("$imc ", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
        Text(
            text = "Registrar un nou pes",
            Modifier.padding(top = 16.dp)
        )
        OutlinedTextField(
            label = { Text(text = "Nou pes kg") },
            value = pesInputText,
            onValueChange = { input ->
                if (input.isEmpty() || input.matches(Regex("^\\d*[.,]?\\d*$"))) {
                    pesInputText = input
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            singleLine = true,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )
        Button(
            onClick = {
                val nouPesDouble = pesInputText.replace(',', '.').toDoubleOrNull()
                if (nouPesDouble != null && nouPesDouble > 0) {
                    _pes = nouPesDouble
                    val data = System.currentTimeMillis()
                    listPes.add(0, WeightTracking(_pes, data))
                    Log.i(TAG, "Array de pes: $listPes")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "Guardar pes")
        }
        Text(
            text = "Evolució del pes",
            Modifier.padding(top = 16.dp, start = 8.dp)
        )
        Card(modifier = Modifier.padding(8.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )
        }
        Text(
            text = "Ultims registres",
            Modifier.padding(top = 16.dp, start = 8.dp)
        )
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(
                items = listPes,
                key = { weightTracking -> weightTracking.data }
            ) { weightTracking ->
                WeightTrackingItem(weightTracking)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TrackingScreenPreview() {
    FitnessAppBTheme {
        WeightTrackingScreen(70.0, 60.0, 170)
    }
}
