package org.insbaixcamp.fitnessappb.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.insbaixcamp.fitnessappb.data.Exercise

@Composable
fun ExerciseItem(exercise: Exercise) {

    Card(
    modifier = Modifier.fillMaxWidth(),
    shape = RoundedCornerShape(12.dp)
    )
    {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            AsyncImage(
                model = exercise.gifUrl,
                contentDescription = exercise.name,
                modifier = Modifier.size(96.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = exercise.name,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(4.dp))

                Text(
                    text = exercise.bodyParts
                        .joinToString(", "),
                    style = MaterialTheme
                        .typography.bodySmall
                )

                Text(
                    text = exercise.targetMuscles
                        .joinToString(", "),
                    style = MaterialTheme
                        .typography.bodySmall
                )
            }
        }
    }
}

