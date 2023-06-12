package com.angel.airquality.view.externalSensorsScreen.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun RoundFloatingButton(
    imageVector: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier
) {
    FloatingActionButton(
        onClick = onClick,
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null
        )
    }
}