package org.insbaixcamp.fitnessappb.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.insbaixcamp.fitnessappb.ui.component.ExerciseItem
import org.insbaixcamp.fitnessappb.ui.theme.FitnessAppBTheme
import org.insbaixcamp.fitnessappb.ui.vm.TrainingViewModel

@Composable
fun TrainingScreen (
    viewModel: TrainingViewModel = viewModel()) {
    val exercises = viewModel.exercises
    val isLoading = viewModel.isLoading
    val error = viewModel.error
    var cercar: String by remember { mutableStateOf("") }

    Column(Modifier.fillMaxWidth()) {

        OutlinedTextField(
            value = cercar,
            onValueChange = {  cercar = it
                            viewModel.findExercises(cercar)
                            },
            label = { Text("Cercar") },
            modifier = Modifier.fillMaxWidth()
                .padding(top= 16.dp,bottom = 8.dp, start= 16.dp, end= 16.dp)
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {

            items(
                items = exercises,
                key = { it.exerciseId }
            ) { exercise -> ExerciseItem(exercise)
            }
        }

    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun TrainingScreenPreview() {

    FitnessAppBTheme {
        TrainingScreen(TrainingViewModel())
    }
}