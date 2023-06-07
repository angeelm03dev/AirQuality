package com.angel.airquality.view.splashScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.angel.airquality.MainActivity
import com.angel.airquality.view.splashScreen.components.Splash
import com.angel.airquality.viewModel.SplashViewModel

@Composable
fun SplashScreen(context: MainActivity, navController: NavController){

    val splashViewModel = viewModel<SplashViewModel>()

    LaunchedEffect(key1 = true){
        splashViewModel.dataLoad(context = context, navController = navController)
        //splashViewModel.searchPollutionNews(context = context)
    }
    Splash()
}