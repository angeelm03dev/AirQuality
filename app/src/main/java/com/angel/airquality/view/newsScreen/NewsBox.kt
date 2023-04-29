package com.angel.airquality.view.newsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun NewsBox(
    title: String?,
    description: String?,
    image: String?,
    author: String?,
    published_at: String?,
    url: String?
) {

    Column(
        modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 15.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(color = Color.LightGray)
            .wrapContentHeight()
    ) {
        ImageNew(image)
        Column(modifier = Modifier.padding(12.dp)) {
            TitleText(title)
            DescriptionText(description, modifier = Modifier.padding(bottom = 8.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                AuthorText(author)
                Published_atText(published_at)
            }
        }
    }
}

@Composable
fun ImageNew(image: String?, modifier: Modifier = Modifier) {
    if (image != null) {
        AsyncImage(
            model = image, contentDescription = null, modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
        )
    }
}

@Composable
fun AuthorText(author: String?, modifier: Modifier = Modifier) {
    if (author != null) {
        Text(text = author, modifier = modifier)
    } else {
        Text(text = "Autor desconocido", modifier = modifier)
    }
}

@Composable
fun TitleText(title: String?, modifier: Modifier = Modifier) {
    if (title != null) {
        Text(text = title, fontWeight = FontWeight.Bold, modifier = modifier)
    } else {
        Text(text = "Sin título", modifier = modifier)
    }
}

@Composable
fun DescriptionText(description: String?, modifier: Modifier = Modifier) {
    if (description != null) {
        Text(text = description, modifier = modifier)
    } else {
        Text(text = "Sin descripción", modifier = modifier)
    }
}

@Composable
fun Published_atText(published_at: String?, modifier: Modifier = Modifier) {
    if (published_at != null) {
        Text(
            text = published_at.substring(0, 10),
            modifier = modifier
        )
    } else {
        Text(text = "Fecha desconocida", modifier = modifier)
    }
}