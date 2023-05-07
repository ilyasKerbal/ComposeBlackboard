package io.github.ilyaskerbal.authentication.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.ilyaskerbal.authentication.AuthenticationMode
import io.github.ilyaskerbal.authentication.R

@Composable
fun AuthenticationForm(
	modifier: Modifier = Modifier,
	authenticationMode: AuthenticationMode,
	email: String,
	onEmailChange: (email: String) -> Unit,
	password: String,
	onPasswordChange: (password: String) -> Unit,
	onAuthenticate: () -> Unit
) {
	val passwordFocusRequester: FocusRequester = FocusRequester()
	Column(
		modifier = modifier,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.form_top_spacer)))
		FormTile(authenticationMode = authenticationMode)
		Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.form_title_spacer)))

		Card(
			modifier = Modifier
				.fillMaxWidth()
				.padding(dimensionResource(id = R.dimen.padding_32)),
			elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
		) {
			Column(
				modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_16)),
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				EmailInput(
					modifier = Modifier.fillMaxWidth(),
					email = email,
					onEmailChanged = onEmailChange,
					onNextClicked = {
						passwordFocusRequester.requestFocus()
					}
				)
				Spacer(modifier = Modifier.height(16.dp))
				PasswordInput(
					modifier = Modifier.fillMaxWidth().focusRequester(passwordFocusRequester),
					password = password,
					onPasswordChange = onPasswordChange,
					onDoneClicked = onAuthenticate
				)
			}
		}
	}
}

@Composable
fun FormTile(
	authenticationMode: AuthenticationMode
){
	Text(
		text = stringResource(id = authenticationMode.title),
		fontWeight = FontWeight.Black,
		fontSize = dimensionResource(id = R.dimen.form_title_font_size).value.sp
	)
}

@Preview(showSystemUi = true)
@Composable
private fun AuthenticationFormPreview() {
	AuthenticationForm(
		authenticationMode = AuthenticationMode.LOG_IN,
		onEmailChange = {},
		email = "test@example.com",
		password = "test",
		onPasswordChange = {},
		onAuthenticate = {}
	)
}

@Preview(showSystemUi = true)
@Composable
private fun AuthenticationFormPreviewSignup() {
	AuthenticationForm(
		authenticationMode = AuthenticationMode.SIGN_UP,
		onEmailChange = {},
		email = "",
		password = "",
		onPasswordChange = {},
		onAuthenticate = {}
	)
}
