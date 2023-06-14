package com.angel.airquality.view.localSensorsScreen.components

import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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


@Composable
fun HistoryGraphBox(points: LineChartData, modifier: Modifier) {
    Box(modifier = modifier){
        LineChart(
            lineChartData = points,
            modifier = Modifier.fillMaxSize(),
            animation = TweenSpec(durationMillis = 1000),
            pointDrawer = FilledCircularPointDrawer(diameter = 0.dp),
            lineDrawer = SolidLineDrawer(thickness = 3.dp, color = Color(0xFF406E91)),
            xAxisDrawer = SimpleXAxisDrawer(axisLineThickness = 2.dp, drawLabelEvery = 2),
            yAxisDrawer = SimpleYAxisDrawer(axisLineThickness = 2.dp, drawLabelEvery = 2),
            horizontalOffset = 1f,
        )
    }
}