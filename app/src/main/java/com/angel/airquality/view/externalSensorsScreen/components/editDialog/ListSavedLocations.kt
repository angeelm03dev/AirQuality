package com.angel.airquality.view.externalSensorsScreen.components.editDialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ListSavedLocations(locations: SnapshotStateList<String>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight(0.40F)
            .background(color = Color.LightGray)
    ){
        locations.forEach {
            item {
                ItemLocation(location = it, locations = locations)
            }
        }
    }
}