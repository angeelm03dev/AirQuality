package com.angel.airquality.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.angel.airquality.MainActivity
import com.angel.airquality.view.homeScreen.HomeScreen
import com.angel.airquality.view.infoScreen.InfoScreen
import com.angel.airquality.view.settingScreen.SettingScreen
import com.angel.airquality.view.splashScreen.SplashScreen

@Composable
fun ScreensNavigation(navController: NavHostController){

    NavHost(navController = navController, startDestination = AppScreens.Splash.ruta){
        composable(AppScreens.Splash.ruta){
            SplashScreen(navController)
        }
        composable(AppScreens.Setting.ruta){
            SettingScreen(navController)
        }
        composable(AppScreens.Info.ruta){
            InfoScreen(navController)
        }
        composable(AppScreens.Home.ruta){
            HomeScreen(navController)
        }
    }

}