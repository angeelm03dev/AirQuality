package com.angel.airquality.view.newsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.angel.airquality.MainActivity
import com.angel.airquality.viewModel.NewsViewModel

@Composable
fun NewsScreen(context: MainActivity, innerPadding: PaddingValues) {

    val newsViewModel = viewModel<NewsViewModel>()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        //En este punto conectariamos con el viewModel para consultar a la API
        newsViewModel.searchPollutionNews(context)

        LazyColumn {
            newsViewModel.pollutionNews.forEach {
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