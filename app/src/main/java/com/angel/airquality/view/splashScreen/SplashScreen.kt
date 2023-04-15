package com.angel.airquality.view.splashScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.angel.airquality.navigation.AppScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){

    LaunchedEffect(key1 = true){
        delay(2000)
        navController.popBackStack()
        navController.navigate(AppScreens.Home.ruta)
    }
    Splash()
}