package com.bsoft.navigation3test.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bsoft.navigation3test.viewmodels.AuthSharedViewModel
import com.bsoft.navigation3test.viewmodels.LoginViewModel

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier, viewModel: LoginViewModel = viewModel(), sharedViewModel: AuthSharedViewModel = viewModel(),
    onLogin: () -> Unit, onRegisterClick: () -> Unit
) {
    val localCounter by viewModel.counter.collectAsStateWithLifecycle()
    val sharedCounter by sharedViewModel.counter.collectAsStateWithLifecycle()

    Box(modifier = modifier.fillMaxSize().padding(20.dp)) {
        Column(modifier = Modifier.align(Alignment.Center), verticalArrangement = Arrangement.spacedBy(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "$localCounter", fontSize = 60.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Local counter")
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "$sharedCounter", fontSize = 60.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Shared counter")
                }
            }

            Button(onClick = viewModel::increase) {
                Text(text = "Increase local counter")
            }
            Button(onClick = sharedViewModel::increase) {
                Text(text = "Increase shared counter")
            }
        }

        Row(modifier = Modifier.align(Alignment.BottomCenter).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = onLogin) {
                Text(text = "Login")
            }
            Button(onClick = onRegisterClick) {
                Text(text = "Register")
            }
        }
    }
}

@Composable
@Preview
fun LoginScreenPreview() {
    LoginScreen(onLogin = {}, onRegisterClick = {})
}