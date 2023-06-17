package com.angel.airquality.view.localSensorsScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.angel.airquality.R
import me.bytebeats.views.charts.line.LineChartData

@Composable
fun HistoryBox(points: MutableState<LineChartData>) {
    Column(
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.historical_data),
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(textAlign = TextAlign.Center, fontSize = 18.sp)
            )
        }
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            HistoryGraphBox(
                points = points.value,
                modifier = Modifier
                    .height(300.dp)
                    .padding(10.dp)
            )
        }
    }

}