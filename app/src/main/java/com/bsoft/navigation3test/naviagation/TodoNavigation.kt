package com.bsoft.navigation3test.naviagation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.bsoft.navigation3test.ui.screens.TodoDetailsScreen
import com.bsoft.navigation3test.ui.screens.TodoListScreen

@Composable
fun TodoNavigation(modifier: Modifier = Modifier) {
    val todoBackStack = remember { mutableStateListOf<Route>(Route.Todo.Todolist) }

    NavDisplay(
        modifier = modifier,
        backStack = todoBackStack,
        onBack = { todoBackStack.removeLastOrNull() },
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator{
                false
            }
        ),
        entryProvider = entryProvider{
            entry<Route.Todo.Todolist> {
                TodoListScreen(onclick = { todoBackStack.add(Route.Todo.TodolistDetail(it)) })
            }
            entry<Route.Todo.TodolistDetail> {
                TodoDetailsScreen(todo = it.todo)
            }
        }
    )
}