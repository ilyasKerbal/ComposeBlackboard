package io.github.ilyaskerbal.authentication.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.ilyaskerbal.authentication.AuthenticationViewModel

@Composable
fun Authentication() {

	val viewModel: AuthenticationViewModel = viewModel()
	val authenticationState by viewModel.authenticationState.collectAsState()

	AuthenticationContent(
		modifier = Modifier.fillMaxSize(),
		authenticationState = authenticationState,
		eventHandler = viewModel::handleEvent
	)
}