package com.angel.airquality.view.settingScreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.angel.airquality.MainActivity
import com.angel.airquality.view.settingScreen.components.SelectTheme
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
        Row(modifier = Modifier.padding(padding).padding(25.dp), verticalAlignment = Alignment.CenterVertically) {
            Text("Appearance")
            Spacer(modifier = Modifier.width(20.dp))
            SelectTheme(context = context, settingsViewModel = settingsViewModel)
        }
    }

}
