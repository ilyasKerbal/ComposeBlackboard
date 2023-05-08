package io.github.ilyaskerbal.authentication.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import io.github.ilyaskerbal.authentication.AuthenticationEvent
import io.github.ilyaskerbal.authentication.AuthenticationState
import io.github.ilyaskerbal.authentication.R

@Composable
fun AuthenticationContent(
	modifier: Modifier = Modifier,
	authenticationState: AuthenticationState,
	eventHandler: (AuthenticationEvent) -> Unit
) {
	Box(
		modifier = modifier,
		contentAlignment = Alignment.Center
	) {
		if (authenticationState.isLoading) {
			CircularProgressIndicator()
		} else {
			AuthenticationForm(
				modifier = Modifier.fillMaxSize(),
				authenticationMode = authenticationState.authenticationMode,
				email = authenticationState.email,
				onEmailChange = {
					eventHandler(AuthenticationEvent.EmailChanged(it))
				},
				password = authenticationState.password,
				onPasswordChange = {
					eventHandler(AuthenticationEvent.PasswordChanged(it))
				},
				onAuthenticate = {
					eventHandler(AuthenticationEvent.Authenticate)
				},
				satisfiedRequirements = authenticationState.validRequirements
			)
		}
	}
}