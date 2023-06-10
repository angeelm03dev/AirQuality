package com.angel.airquality.view.localSensorsScreen.components

import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import me.bytebeats.views.charts.line.LineChart
import me.bytebeats.views.charts.line.LineChartData
import me.bytebeats.views.charts.line.render.line.SolidLineDrawer
import me.bytebeats.views.charts.line.render.point.FilledCircularPointDrawer
import me.bytebeats.views.charts.line.render.xaxis.SimpleXAxisDrawer
import me.bytebeats.views.charts.line.render.yaxis.SimpleYAxisDrawer
import me.bytebeats.views.charts.simpleChartAnimation


@Composable
fun HistoryGraphBox(modifier: Modifier) {
    Box(modifier = modifier){
        LineChart(
            lineChartData = LineChartData(
                points = listOf(
                    LineChartData.Point(20F, "00h"),
                    LineChartData.Point(15F, "01h"),
                    LineChartData.Point(15F, "02h"),
                    LineChartData.Point(15F, "03h"),
                    LineChartData.Point(5F, "04h"),
                    LineChartData.Point(15F, "05h"),
                    LineChartData.Point(35F, "06h"),
                    LineChartData.Point(12F, "07h"),
                    LineChartData.Point(20F, "08h"),
                    LineChartData.Point(89F, "09h"),
                    LineChartData.Point(22F, "10h"),
                    LineChartData.Point(15F, "11h"),
                    LineChartData.Point(25F, "12h"),
                    LineChartData.Point(15F, "13h"),
                    LineChartData.Point(20F, "14h"),
                    LineChartData.Point(12F, "15h"),
                    LineChartData.Point(19F, "16h"),
                    LineChartData.Point(15F, "17h"),
                    LineChartData.Point(59F, "18h"),
                    LineChartData.Point(15F, "19h"),
                    LineChartData.Point(1000F, "20h"),
                    LineChartData.Point(15F, "21h"),
                    LineChartData.Point(20F, "22h"),
                    LineChartData.Point(15F, "23h"),
                )
            ),
            // Optional properties.
            modifier = Modifier.fillMaxSize(),
            animation = TweenSpec(durationMillis = 1000),
            pointDrawer = FilledCircularPointDrawer(diameter = 0.dp),
            lineDrawer = SolidLineDrawer(thickness = 3.dp, color = Color.Blue),
            xAxisDrawer = SimpleXAxisDrawer(axisLineThickness = 2.dp, drawLabelEvery = 2),
            yAxisDrawer = SimpleYAxisDrawer(axisLineThickness = 2.dp, drawLabelEvery = 2),
            horizontalOffset = 1f
        )
    }
}