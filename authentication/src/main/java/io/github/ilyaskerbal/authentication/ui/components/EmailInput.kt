package io.github.ilyaskerbal.authentication.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import io.github.ilyaskerbal.authentication.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailInput(
	modifier: Modifier = Modifier,
	email: String,
	onEmailChanged: (email: String) -> Unit
) {
	TextField(
		modifier = modifier,
		value = email,
		onValueChange = onEmailChanged,
		label = {
			Text(
				text = stringResource(id = R.string.email_address)
			)
		},
		singleLine = true,
		leadingIcon = {
			Icon(
				imageVector = Icons.Filled.Email,
				contentDescription = null)
		}
	)
}

@Preview
@Composable
fun EmailInputPreviewEmpty() {
	EmailInput(email = "", onEmailChanged = {} )
}

@Preview
@Composable
fun EmailInputPreview() {
	EmailInput(email = "email@example.com", onEmailChanged = {} )
}