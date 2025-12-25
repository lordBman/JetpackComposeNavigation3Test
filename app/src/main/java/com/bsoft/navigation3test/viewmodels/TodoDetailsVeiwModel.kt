package com.bsoft.navigation3test.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TodoDetailsViewModel(private val todo: String): ViewModel() {
    private val _state = MutableStateFlow(TodoDetails(todo))

    val state = _state.asStateFlow()
}

data class TodoDetails(
    val todo: String
)