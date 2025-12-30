package com.bsoft.navigation3test.naviagation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.bsoft.navigation3test.ui.screens.LoginScreen
import com.bsoft.navigation3test.ui.screens.RegisterScreen
import com.bsoft.navigation3test.viewmodels.AuthSharedViewModel

@Composable
fun AuthNavigation(modifier: Modifier = Modifier, onLogin: () -> Unit) {
    val authBackStack = remember { mutableStateListOf<Route>(Route.Auth.Login) }

    val sharedViewModel = viewModel{ AuthSharedViewModel() }
    NavDisplay(
        backStack = authBackStack,
        onBack = { authBackStack.removeLastOrNull() },
        entryProvider = entryProvider{
            entry<Route.Auth.Login> {
                LoginScreen(modifier = modifier, sharedViewModel = sharedViewModel, onLogin = onLogin, onRegisterClick = { authBackStack.add(Route.Auth.Register) })
            }
            entry<Route.Auth.Register> {
                RegisterScreen(modifier = modifier, sharedViewModel = sharedViewModel)
            }
        }
    )
}