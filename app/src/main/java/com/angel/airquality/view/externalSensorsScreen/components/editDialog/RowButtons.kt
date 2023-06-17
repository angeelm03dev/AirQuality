package com.angel.airquality.view.externalSensorsScreen.components.editDialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.angel.airquality.GlobalVars
import com.angel.airquality.MainActivity
import com.angel.airquality.R
import com.angel.airquality.ui.theme.OffBlue
import com.angel.airquality.viewModel.ExternalSensorsViewModel

@Composable
fun RowButton(
    openDialog: MutableState<Boolean>
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            colors =  ButtonDefaults.buttonColors(backgroundColor = OffBlue),
            onClick = {
                openDialog.value = false
            }
        ) {
            Text(text = stringResource(R.string.back_btn))
        }
    }
}