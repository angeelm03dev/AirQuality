package com.angel.airquality.view.homeScreen

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.angel.airquality.GlobalVars
import com.angel.airquality.MainActivity
import com.angel.airquality.R
import com.angel.airquality.view.externalSensorsScreen.ExternalSensorsScreen
import com.angel.airquality.view.homeScreen.components.Drawer
import com.angel.airquality.view.homeScreen.components.MyTopAppBar
import com.angel.airquality.view.localSensorsScreen.LocalSensorsScreen
import com.angel.airquality.view.newsScreen.NewsScreen
import com.angel.airquality.viewModel.ExternalSensorsViewModel

@Composable
fun HomeScreen(context: MainActivity, screensNavController: NavHostController) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val externalSensorsViewModel = viewModel<ExternalSensorsViewModel>()

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            BottomAppBar {
                BottomNavigationItem(
                    selected = GlobalVars.currentScreen.value == Screen.LocalSensors,
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "Sensores propios",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    onClick = { GlobalVars.currentScreen.value = Screen.LocalSensors },
                    label = { Text("Local") }
                )
                BottomNavigationItem(
                    selected = GlobalVars.currentScreen.value == Screen.ExternalSensors,
                    icon = {
                        Icon(
                            painterResource(R.drawable.location_city),
                            contentDescription = "Estaciones estatales",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    onClick = { GlobalVars.currentScreen.value = Screen.ExternalSensors },
                    label = { Text("External") }
                )
                BottomNavigationItem(
                    selected = GlobalVars.currentScreen.value == Screen.NewsSensors,
                    icon = {
                        Icon(
                            painterResource(R.drawable.newspaper),
                            contentDescription = "Noticias",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    onClick = { GlobalVars.currentScreen.value = Screen.NewsSensors },
                    label = { Text("News") }
                )
            }
        },
        topBar = {
            MyTopAppBar(
                scope,
                scaffoldState,
                currentScreen = GlobalVars.currentScreen.value
            )
        },
        drawerContent = {
            Drawer(
                scope,
                scaffoldState,
                screensNavController
            )
        }
    ) { innerPadding ->
        when (GlobalVars.currentScreen.value) {
            is Screen.LocalSensors -> {
                LocalSensorsScreen(context = context, innerPadding = innerPadding)
            }

            is Screen.ExternalSensors -> {
                ExternalSensorsScreen(
                    context = context,
                    externalSensorsViewModel,
                    innerPadding = innerPadding
                )
            }

            is Screen.NewsSensors -> {
                NewsScreen(context, innerPadding)
            }
        }
    }

}
