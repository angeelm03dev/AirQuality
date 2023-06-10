package com.angel.airquality.view.localSensorsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Colors
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.angel.airquality.view.localSensorsScreen.components.HistoryGraphBox

@Composable
fun LocalSensorsScreen(innerPadding: PaddingValues) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(10.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RealTimeData(modifier = Modifier.fillMaxWidth())
        HistoryBox()
    }
}

@Composable
fun RealTimeData(modifier: Modifier){
    Column(modifier = modifier) {
        Text(
            text = "Nombre del sensor",
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth()
                .padding(10.dp),
            textAlign = TextAlign.Center
        )
        Row {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .background(color = Color(0xFF009866), shape = CircleShape)
                        .size(125.dp)
                        .fillMaxHeight()
                ) {
                    Text("123", modifier = Modifier.align(Alignment.Center))
                }
                Text(text = "00:00", textAlign = TextAlign.Center)
                Text(text = "01/01/2000", textAlign = TextAlign.Center)
            }

            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Calidad buena ✅",
                    fontWeight = FontWeight.Bold,
                    fontSize = 21.sp,
                    modifier = Modifier
                        .padding(vertical = 10.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "La calidad del aire es buena y no debería producir problemas de salud",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(vertical = 10.dp)
                        .padding(10.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun HistoryBox(){
    Column(
        verticalArrangement = Arrangement.Bottom
    ){
        Divider(
            color = Color.Black,
            thickness = 1.dp,
            modifier = Modifier.padding(vertical = 5.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Flecha atrás")
            }

            Column(
                modifier = Modifier.align(Alignment.CenterVertically).padding(10.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Historial", fontWeight = FontWeight.SemiBold, modifier = Modifier.align(Alignment.CenterHorizontally))
                Text(text = "01/01/2000", textAlign = TextAlign.Center)
            }

            Button(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Flecha atrás")
            }
        }
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            HistoryGraphBox(
                modifier = Modifier
                    .height(300.dp)
                    .padding(10.dp)
            )
        }
    }

}