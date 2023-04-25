package com.angel.airquality.view.newsScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.angel.airquality.R

@Preview
@Composable
fun NewsBox() {
    Row(
        modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 10.dp)
            .background(Color.LightGray)
            .fillMaxWidth()
            .heightIn(200.dp)
    ) {
        Column() {
            Text("Titular de la noticia")
            Text("Descripción de la noticia. Loretata")
        }
        Image(painter = painterResource(R.drawable.ic_launcher_background), modifier = Modifier.width(500.dp), contentDescription = "Imagen de la noticia")
    }

}