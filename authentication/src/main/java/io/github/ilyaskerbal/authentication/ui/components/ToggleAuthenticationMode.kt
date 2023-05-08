package io.github.ilyaskerbal.authentication.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.ilyaskerbal.authentication.AuthenticationMode

@Composable
fun ToggleAuthenticationMode(
    modifier: Modifier = Modifier,
    authenticationMode: AuthenticationMode,
    onToggleAuthentication: () -> Unit = {}
){
	Surface(
		modifier = modifier.padding(top = 12.dp),
		shadowElevation = 8.dp
	) {
		TextButton(
			onClick = onToggleAuthentication,
		) {
			Text(
				text = stringResource(id = authenticationMode.toggle)
			)
		}
	}
}

@Preview
@Composable
private fun ToggleAuthenticationModePreviewLogin(){
	ToggleAuthenticationMode(
		authenticationMode = AuthenticationMode.LOG_IN
	)
}

@Preview
@Composable
private fun ToggleAuthenticationModePreviewSignup(){
	ToggleAuthenticationMode(
		authenticationMode = AuthenticationMode.SIGN_UP
	)
}