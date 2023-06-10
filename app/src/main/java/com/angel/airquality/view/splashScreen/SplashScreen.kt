package com.angel.airquality.view.splashScreen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.room.Room
import com.angel.airquality.GlobalVars
import com.angel.airquality.MainActivity
import com.angel.airquality.database.AppDatabase
import com.angel.airquality.view.splashScreen.components.Splash
import com.angel.airquality.viewModel.SplashViewModel
import kotlinx.coroutines.runBlocking

@Composable
fun SplashScreen(context: MainActivity, navController: NavController){

    val splashViewModel = viewModel<SplashViewModel>()

    LaunchedEffect(key1 = true){
        runBlocking {
            GlobalVars.db = Room.databaseBuilder(context, AppDatabase::class.java, "db_airquality.db")
                .createFromAsset("database/db_airquality.db")
                .build()
        }

        try{
            splashViewModel.loadLocationMap(context, navController)
        }catch (e: Exception){
            Log.e("ERROR", e.toString())
        }
        //splashViewModel.searchPollutionNews(context = context)
    }
    Splash()
}