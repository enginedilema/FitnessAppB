package org.insbaixcamp.fitnessappb.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.insbaixcamp.fitnessappb.data.WeightTracking
import org.insbaixcamp.fitnessappb.ui.theme.FitnessAppBTheme

@Composable
fun WeightTrackingItem(item: WeightTracking) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.DateRange,
            contentDescription = "Calendari",
            modifier = Modifier.padding(end = 4.dp)
        )
        Text(
            text = formatDate(item.data),
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "${item.pes} Kg",
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WeightTrackingItemPreview() {
    val data = System.currentTimeMillis()
    val pes = 70.0
    val item = WeightTracking(pes, data)
    FitnessAppBTheme {
        WeightTrackingItem(item)
    }
}
