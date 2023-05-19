package com.angel.airquality.view.homeScreen.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MyTopAppBar(scope: CoroutineScope, scaffoldState: ScaffoldState, title: String) {
    TopAppBar(
        elevation = 4.dp,
        backgroundColor = Color.White,
        modifier = Modifier.height(56.dp)
    ) {
        IconButton(onClick = { scope.launch { scaffoldState.drawerState.open() } }) {
            Icon(
                Icons.Filled.Menu,
                contentDescription = "Sensores propios",
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = title,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}