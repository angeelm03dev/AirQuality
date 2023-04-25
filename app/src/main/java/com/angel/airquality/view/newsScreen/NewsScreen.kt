package com.angel.airquality.view.newsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NewsScreen(innerPadding : PaddingValues) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        //En este punto conectariamos con el viewModel para consultar a la API
        LazyColumn {
            items(20){
                NewsBox()
            }
        }
    }

}