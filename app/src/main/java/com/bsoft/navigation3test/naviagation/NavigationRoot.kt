package com.bsoft.navigation3test.naviagation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay

@Composable
fun NavigationRoot(modifier: Modifier = Modifier){
    val rootBackStack = remember { mutableStateListOf<Route>(Route.Auth) }

    NavDisplay(
        backStack = rootBackStack, onBack = { rootBackStack.removeLastOrNull() }, entryProvider = entryProvider {
            entry<Route.Auth> {
                AuthNavigation(modifier = modifier, onLogin = { rootBackStack.remove(Route.Auth); rootBackStack.add(Route.Todo) })
            }
            entry<Route.Todo> {
                TodoNavigation(modifier = modifier)
            }
        })
}