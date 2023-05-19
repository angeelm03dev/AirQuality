package com.angel.airquality.view.splashScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.angel.airquality.navigation.AppScreens
import com.angel.airquality.view.splashScreen.components.Splash
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){

    LaunchedEffect(key1 = true){
        delay(1500)
        navController.popBackStack()
        navController.navigate(AppScreens.Home.ruta)
    }
    Splash()
}