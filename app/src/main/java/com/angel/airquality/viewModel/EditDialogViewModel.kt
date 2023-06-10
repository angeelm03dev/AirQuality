package com.angel.airquality.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class EditDialogViewModel : ViewModel() {
    private val _searchFieldValue = mutableStateOf("")
    val searchFieldValue: State<String> = _searchFieldValue

    fun updateSearchTextFieldValue(newValue: String) {
        _searchFieldValue.value = newValue
    }
}