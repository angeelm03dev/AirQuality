package com.angel.airquality.view.externalSensorsScreen.components.editDialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.angel.airquality.GlobalVars
import com.angel.airquality.viewModel.ExternalSensorsViewModel

@Composable
fun ListLocations(
    locations: SnapshotStateList<String>,
    externalSensorsViewModel: ExternalSensorsViewModel
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight(0.45F)
            .clip(RoundedCornerShape(25.dp))
            .background(color = MaterialTheme.colors.secondaryVariant)
    ) {
        locations.forEach { location ->
            item {
                ItemLocation(
                    location = location,
                    externalSensorsViewModel = externalSensorsViewModel
                )
            }
        }
    }
}