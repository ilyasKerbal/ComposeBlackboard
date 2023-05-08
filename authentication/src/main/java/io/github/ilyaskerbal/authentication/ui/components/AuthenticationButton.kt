package io.github.ilyaskerbal.authentication.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import io.github.ilyaskerbal.authentication.AuthenticationMode

@Composable
fun AuthenticationButton(
    modifier: Modifier = Modifier,
    authenticationMode: AuthenticationMode,
    enableAuthentication: Boolean,
    onAuthenticate: () -> Unit = {}
){
    Button(
	    modifier = modifier,
	    onClick = onAuthenticate,
	    enabled = enableAuthentication
    ) {
		Text(
			text = stringResource(id = authenticationMode.label)
		)
    }
}

@Preview(showBackground = true)
@Composable
private fun AuthenticationButtonLogin(){
	AuthenticationButton(
		authenticationMode = AuthenticationMode.LOG_IN,
		enableAuthentication = true
	)
}

@Preview(showBackground = true)
@Composable
private fun AuthenticationButtonLoginDisabled(){
	AuthenticationButton(
		authenticationMode = AuthenticationMode.LOG_IN,
		enableAuthentication = false
	)
}

@Preview(showBackground = true)
@Composable
private fun AuthenticationButtonSignup(){
	AuthenticationButton(
		authenticationMode = AuthenticationMode.SIGN_UP,
		enableAuthentication = true
	)
}

@Preview(showBackground = true)
@Composable
private fun AuthenticationButtonSignupDisabled(){
	AuthenticationButton(
		authenticationMode = AuthenticationMode.SIGN_UP,
		enableAuthentication = false
	)
}