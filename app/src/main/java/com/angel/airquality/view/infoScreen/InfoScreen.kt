package com.angel.airquality.view.infoScreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun InfoScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 4.dp,
                backgroundColor = Color.White,
                modifier = Modifier.height(56.dp)
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = "Sensores propios",
                        modifier = Modifier.size(24.dp)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Info",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        }

    ) { padding ->
        Column(modifier = Modifier.padding(padding), horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Creditos: Ángel Moreno Muñoz",style = MaterialTheme.typography.body1)
        }
    }
}