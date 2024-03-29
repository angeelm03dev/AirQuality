package com.angel.airquality.view.newsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.angel.airquality.GlobalVars
import com.angel.airquality.MainActivity
import com.angel.airquality.view.newsScreen.components.NewsBox
import com.angel.airquality.viewModel.NewsViewModel

@Composable
fun NewsScreen(innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colors.primaryVariant)
            .padding(innerPadding)
            .fillMaxSize()
    ) {
        LazyColumn {
            GlobalVars.pollutionNews.forEach {
                item {
                    NewsBox(
                        title = it.title,
                        description = it.description,
                        image = it.image,
                        author = it.author,
                        published_at = it.published_at,
                        url = it.url
                    )
                }
            }
        }
    }

}