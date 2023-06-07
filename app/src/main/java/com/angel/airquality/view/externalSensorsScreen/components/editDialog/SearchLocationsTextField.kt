package com.angel.airquality.view.externalSensorsScreen.components.editDialog

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import com.angel.airquality.viewModel.EditDialogViewModel

@Composable
fun SearchLocationsTextField(
    editDialogViewModel: EditDialogViewModel,
    openSearch: MutableState<Boolean>
) {
    val textFieldValue = editDialogViewModel.searchFieldValue.value

    TextField(
        value = textFieldValue,
        placeholder = {
            Text(
                text = "Buscar localidad",
                color = Color.LightGray
            )
        },
        onValueChange = { editDialogViewModel.updateSearchTextFieldValue(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent, //hide the indicator
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            textColor = Color.Black,
            cursorColor = Color(0xFFF7C324),
            placeholderColor = Color.Black,
            backgroundColor = Color(255, 255, 255, 25)
        ),
        singleLine = true,
        shape = CircleShape,
    )
}