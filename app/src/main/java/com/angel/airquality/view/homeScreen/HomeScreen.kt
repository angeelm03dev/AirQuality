package com.angel.airquality.view.homeScreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.angel.airquality.MainActivity
import com.angel.airquality.R
import com.angel.airquality.view.externalSensorsScreen.ExternalSensorsScreen
import com.angel.airquality.view.localSensorsScreen.LocalSensorsScreen
import com.angel.airquality.view.newsScreen.NewsScreen

@Composable
fun HomeScreen(context: MainActivity, screensNavController: NavHostController) {
    var screen: Screen = Screen.LocalSensors
    var currentScreen by remember { mutableStateOf(screen) }

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            BottomAppBar {
                BottomNavigationItem(
                    selected = currentScreen == Screen.LocalSensors,
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "Sensores propios",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    onClick = { currentScreen = Screen.LocalSensors },
                    label = { Text("Local") }
                )
                BottomNavigationItem(
                    selected = currentScreen == Screen.ExternalSensors,
                    icon = {
                        Icon(
                            painterResource(R.drawable.location_city),
                            contentDescription = "Estaciones estatales",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    onClick = { currentScreen = Screen.ExternalSensors },
                    label = { Text("External") }
                )
                BottomNavigationItem(
                    selected = currentScreen == Screen.NewsSensors,
                    icon = {
                        Icon(
                            painterResource(R.drawable.newspaper),
                            contentDescription = "Noticias",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    onClick = { currentScreen = Screen.NewsSensors },
                    label = { Text("News") }
                )
            }
        },
        topBar = { MyTopAppBar(scope, scaffoldState, title = currentScreen.title) },
        drawerContent = {
            Drawer(
                scope,
                scaffoldState,
                screensNavController
            )
        }
    ) { innerPadding ->
        when (currentScreen) {
            is Screen.LocalSensors -> {
                LocalSensorsScreen(innerPadding)
            }

            is Screen.ExternalSensors -> {
                ExternalSensorsScreen(innerPadding)
            }

            is Screen.NewsSensors -> {
                NewsScreen(context, innerPadding)
            }

            else -> {}
        }
    }

}
