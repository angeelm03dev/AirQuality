package com.angel.airquality.navigation

sealed class AppScreens(
    val ruta: String
){
    object Splash: AppScreens("splash")
    object Setting: AppScreens("setting")
    object Info: AppScreens("info")
    object Home: AppScreens("home")
}
