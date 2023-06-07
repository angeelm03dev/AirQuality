package com.angel.airquality.view.externalSensorsScreen.components.editDialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.angel.airquality.GlobalVars

@Composable
fun ItemLocation(location: String, locations: SnapshotStateList<String>){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ){
        Text(text = location, modifier = Modifier.padding(top = 13.dp))
        IconButton(
            onClick = {
                GlobalVars.locationsList.remove(location)
            }
        ) {
            Icon(imageVector = Icons.Filled.Delete, contentDescription = "Eliminar")
        }
    }
}