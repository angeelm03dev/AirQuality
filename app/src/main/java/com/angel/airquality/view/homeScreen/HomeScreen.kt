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
import com.angel.airquality.R
import com.angel.airquality.view.externalSensorsScreen.ExternalSensorsScreen
import com.angel.airquality.view.localSensorsScreen.LocalSensorsScreen
import com.angel.airquality.view.newsScreen.NewsScreen

open class Screen {
    object Screen1 : Screen()
    object Screen2 : Screen()
    object Screen3 : Screen()
}

@Composable
fun HomeScreen(screensNavController: NavHostController) {
    var screen: Screen = Screen.Screen1
    var currentScreen by remember {mutableStateOf(screen)}

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            BottomAppBar {
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxSize()
                ) {
                    IconButton(onClick = { currentScreen = Screen.Screen1 }) {
                        Icon(
                            Icons.Filled.Home,
                            contentDescription = "Sensores propios",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    IconButton(onClick = { currentScreen = Screen.Screen2 }) {
                        Icon(
                            painterResource(R.drawable.location_city),
                            contentDescription = "Estaciones estatales",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    IconButton(onClick = { currentScreen = Screen.Screen3 }) {
                        Icon(
                            painterResource(R.drawable.newspaper),
                            contentDescription = "Noticias",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        },
        topBar = { MyTopAppBar(scope, scaffoldState, title = "Mi pantalla") },
        drawerContent = {
            Drawer(
                scope,
                scaffoldState,
                screensNavController
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* ... */ }) {
                Icon(Icons.Filled.Add, contentDescription = "Noticias")
            }
        }
    ) {innerPadding ->
        when (currentScreen) {
            is Screen.Screen1 -> {
                LocalSensorsScreen(innerPadding)
            }
            is Screen.Screen2 -> {
                ExternalSensorsScreen(innerPadding)
            }
            is Screen.Screen3 -> {
                NewsScreen(innerPadding)
            }
        }
    }

}
