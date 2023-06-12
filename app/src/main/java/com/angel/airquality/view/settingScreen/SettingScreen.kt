package com.angel.airquality.view.settingScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.angel.airquality.MainActivity
import com.angel.airquality.viewModel.SettingsViewModel

@Composable
fun SettingScreen(context: MainActivity, navController: NavHostController) {

    val settingsViewModel = viewModel<SettingsViewModel>(context)

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
                    text = "Settings",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        }

    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Borrar datos de sensores seleccionados.\nTanto del apartado LocalSensors como de ExternalSensors.",
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(textAlign = TextAlign.Center, fontSize = 16.sp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Button(onClick = {
                // Aqui se mandaría la pedición al SettingsViewModel de que borre todos los datos correspondiente
            }) {
                Text("Borrar datos")
            }
        }
    }

}
