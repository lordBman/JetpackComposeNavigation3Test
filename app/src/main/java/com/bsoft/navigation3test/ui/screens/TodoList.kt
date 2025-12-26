package com.bsoft.navigation3test.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bsoft.navigation3test.viewmodels.TodoListViewModel

@Composable
fun TodoListScreen(modifier: Modifier = Modifier, viewModel: TodoListViewModel = viewModel(), onclick: (String)-> Unit) {
    val todos by viewModel.todos.collectAsState()

    LazyColumn(modifier = modifier, contentPadding = PaddingValues(16.dp)) {
        items(todos.size) { index ->
            Text(modifier = Modifier.padding(10.dp).clickable { onclick(todos[index]) },
                text = "Todo item: ${todos[index]}",
                style = MaterialTheme.typography.bodyLarge)
        }
    }
}