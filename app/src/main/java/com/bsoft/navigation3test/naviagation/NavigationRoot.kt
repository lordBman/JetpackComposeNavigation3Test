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
fun NavigationRoot(modifier: Modifier = Modifier){
    val backStack = remember { mutableStateListOf<Route>(Route.Todolist) }

    NavDisplay(
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator{
                false
            }
        ),
        backStack = backStack, onBack = { backStack.removeLastOrNull() }, entryProvider = entryProvider {
            entry<Route.Todolist> {
                TodoListScreen(modifier = modifier, onclick = { todo -> backStack.add(Route.TodolistDetail(todo))})
            }
            entry<Route.TodolistDetail> {
                TodoDetailsScreen(modifier = modifier, todo = it.todo)
            }
        })
}