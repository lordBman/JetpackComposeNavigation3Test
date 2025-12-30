package com.bsoft.navigation3test.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthSharedViewModel: ViewModel() {
    private val _counter = MutableStateFlow(0)

    val counter = _counter.asStateFlow()

    fun increase(){
        _counter.value++
    }
}