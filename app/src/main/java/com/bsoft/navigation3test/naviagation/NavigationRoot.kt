package com.bsoft.navigation3test.naviagation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.bsoft.navigation3test.ui.screens.TodoDetailsScreen
import com.bsoft.navigation3test.ui.screens.TodoListScreen

@Composable
fun NavigationRoot(modifier: Modifier = Modifier){
    val backStack = remember { mutableStateListOf<Route>(Route.Todolist) }

    NavDisplay(backStack = backStack, onBack = { backStack.removeLastOrNull() }, entryProvider = { key ->
        when(key){
            is Route.Todolist -> NavEntry(key){
                TodoListScreen(modifier = modifier, onclick = { todo -> backStack.add(Route.TodolistDetail(todo))})
            }
            is Route.TodolistDetail -> NavEntry(key){
                TodoDetailsScreen(modifier = modifier, todo = key.todo)
            }
        }
    })
}