package org.insbaixcamp.fitnessappb.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.insbaixcamp.fitnessappb.ui.component.ExerciseItem
import org.insbaixcamp.fitnessappb.ui.vm.TrainingViewModel

@Composable
fun TrainingScreen (
    viewModel: TrainingViewModel = viewModel()) {
    val exercises = viewModel.exercises
    val isLoading = viewModel.isLoading
    val error = viewModel.error


    Column() {

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