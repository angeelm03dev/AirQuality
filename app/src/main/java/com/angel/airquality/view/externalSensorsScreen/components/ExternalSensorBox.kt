package com.angel.airquality.view.externalSensorsScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.angel.airquality.model.airQualityOpenData.Data

@Composable
fun ExternalSensorBox(dataAirQuality: Data?, location: String, modifier: Modifier) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(15.dp))
            .background(color = Color(0xFFE4CCA7))
            .fillMaxWidth()
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {

        if (dataAirQuality != null) {
            GeneralPollutionIndex(value = dataAirQuality.aqi, location = location)
        }

        Column(
            modifier = Modifier
                .padding(start = 5.dp)
        ) {
            LazyHorizontalGrid(
                rows = GridCells.Fixed(2),
                modifier = Modifier.height(150.dp)
            ){
                val pollutingAgents = dataAirQuality?.iaqi

                val no3 = pollutingAgents?.no3
                val o3 = pollutingAgents?.o3
                val pm10 = pollutingAgents?.pm10
                val pm25 = pollutingAgents?.pm25
                val so2 = pollutingAgents?.so2

                if (no3 != null) {
                    item {
                        ContaminantAgent(type = "NO3", value = no3.v, modifier = Modifier.padding(horizontal = 7.dp))
                    }
                }
                if (o3 != null) {
                    item {
                        ContaminantAgent(type = "O3", value = o3.v, modifier = Modifier.padding(horizontal = 7.dp))
                    }
                }
                if (pm10 != null) {
                    item {
                        ContaminantAgent(type = "PM10", value = pm10.v, modifier = Modifier.padding(horizontal = 7.dp))
                    }
                }
                if (pm25 != null) {
                    item {
                        ContaminantAgent(type = "PM2.5", value = pm25.v, modifier = Modifier.padding(horizontal = 7.dp))
                    }
                }
                if (so2 != null) {
                    item {
                        ContaminantAgent(type = "SO2", value = so2.v, modifier = Modifier.padding(horizontal = 7.dp))
                    }
                }

        }

        }
    }

}
