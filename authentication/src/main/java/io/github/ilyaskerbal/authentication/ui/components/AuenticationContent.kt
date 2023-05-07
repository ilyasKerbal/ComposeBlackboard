package io.github.ilyaskerbal.authentication.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.ilyaskerbal.authentication.AuthenticationEvent
import io.github.ilyaskerbal.authentication.AuthenticationState

@Composable
fun AuthenticationContent(
	modifier: Modifier = Modifier,
	authenticationState: AuthenticationState,
	eventHandler: (AuthenticationEvent) -> Unit
) {

}