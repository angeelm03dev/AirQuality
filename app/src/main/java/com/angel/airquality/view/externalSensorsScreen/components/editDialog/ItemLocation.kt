package com.angel.airquality.view.externalSensorsScreen.components.editDialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.angel.airquality.GlobalVars
import com.angel.airquality.viewModel.ExternalSensorsViewModel

@Composable
fun ItemLocation(
    location: String,
    externalSensorsViewModel: ExternalSensorsViewModel
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
    ) {
        Text(text = location, modifier = Modifier.padding(top = 13.dp))
        Checkbox(
            checked = GlobalVars.locationsMapList[location] == 1,
            onCheckedChange = { isChecked ->
                externalSensorsViewModel.updateIsActive(
                    location = location,
                    isActive = if (isChecked) 1 else 0
                )
            },
            colors = CheckboxDefaults.colors(checkedColor = Color(0xFF1976D2)),
            modifier = Modifier
        )
    }
}