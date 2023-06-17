package com.angel.airquality.view.homeScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.angel.airquality.R
import com.angel.airquality.navigation.AppScreens

@Composable
fun Drawer(
    navController: NavController
) {
    Column {
        Image(
            painter = painterResource(id = R.drawable.contaminacion_ciudad),
            contentDescription = "Menu opciones",
            modifier = Modifier
                .height(160.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(15.dp)
        )
        DrawerItem(
            imageVector = Icons.Filled.Settings,
            title = stringResource(R.string.setings_btn),
            AppScreens.Setting.ruta,
            navController
        )
        DrawerItem(
            imageVector = Icons.Filled.Info,
            title = stringResource(R.string.info_btn),
            AppScreens.Info.ruta,
            navController
        )
    }
}

@Composable
fun DrawerItem(
    imageVector: ImageVector,
    title: String,
    ruta: String,
    navController: NavController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(6.dp)
            .clip(RoundedCornerShape(12))
            .padding(8.dp)
            .clickable { navController.navigate(ruta) }
    ) {
        Image(imageVector = imageVector, contentDescription = title)
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = title, style = MaterialTheme.typography.body1)
    }
}