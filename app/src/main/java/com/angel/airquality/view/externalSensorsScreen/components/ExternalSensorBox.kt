package com.angel.airquality.view.externalSensorsScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ExternalSensorBox(location: String, modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        GeneralPollutionIndex(location)

        Column(
            modifier = Modifier
                .padding(start = 5.dp)
        ) {
            LazyHorizontalGrid(
                rows = GridCells.Fixed(2),
                modifier = Modifier.height(150.dp)
            ){
            item {
                ContaminantAgent("NO3", modifier = Modifier.padding(horizontal = 7.dp))
            }
            item {
                ContaminantAgent("O3", modifier = Modifier.padding(horizontal = 7.dp))
            }
            item {
                ContaminantAgent("PM10", modifier = Modifier.padding(horizontal = 7.dp))
            }
            item {
                ContaminantAgent("PM2.5", modifier = Modifier.padding(horizontal = 7.dp))
            }
            item {
                ContaminantAgent("SO3", modifier = Modifier.padding(horizontal = 7.dp))
            }
        }

        }
    }

}

@Preview
@Composable
fun ExternalSensorBoxPreview() {
    ExternalSensorBox("Puente Genil", modifier = Modifier.padding(vertical = 5.dp))
}