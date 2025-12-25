package com.bsoft.navigation3test.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bsoft.navigation3test.viewmodels.TodoDetailsViewModel

@Composable
fun TodoDetailsScreen(modifier: Modifier = Modifier, todo: String, viewModel: TodoDetailsViewModel = viewModel{
    TodoDetailsViewModel(todo)
}){
    val state by viewModel.state.collectAsState()

    Box(modifier = modifier.fillMaxSize().background(MaterialTheme.colorScheme.secondaryContainer), contentAlignment = Alignment.Center) {
        Text(text = state.todo, style = MaterialTheme.typography.headlineLarge)
    }
}