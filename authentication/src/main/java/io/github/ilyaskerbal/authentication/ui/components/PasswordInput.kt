package io.github.ilyaskerbal.authentication.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import io.github.ilyaskerbal.authentication.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInput(
	modifier: Modifier = Modifier,
	password: String,
	onPasswordChange: (password: String) -> Unit
) {
	var isPasswordHidden: Boolean by remember { mutableStateOf(true) }
	val visibilityIcon: ImageVector by remember {
		derivedStateOf {
			if (isPasswordHidden) Icons.Default.Visibility else Icons.Default.VisibilityOff
		}
	}
	val visualTransformation: VisualTransformation by remember {
		derivedStateOf { if (isPasswordHidden) PasswordVisualTransformation() else VisualTransformation.None }
	}
	TextField(
		modifier = modifier,
		value = password,
		onValueChange = onPasswordChange,
		singleLine = true,
		label = {
			Text(
				text = stringResource(id = R.string.password)
			)
		},
		leadingIcon = {
			Icon(
				imageVector = Icons.Filled.Lock,
				contentDescription = null
			)
		},
		trailingIcon = {
			Icon(
				imageVector = visibilityIcon,
				contentDescription = null,
				modifier = Modifier.clickable(
					onClickLabel = if (isPasswordHidden) {
						stringResource(id = R.string.show_password)
					} else { stringResource(id = R.string.hide_password) }
				){
					isPasswordHidden = !isPasswordHidden
				}
			)
		},
		visualTransformation = visualTransformation
	)
}

@Preview
@Composable
private fun PasswordInputPreview(){
	PasswordInput(password = "admin1234", onPasswordChange = {})
}

@Preview
@Composable
private fun PasswordInputPreviewEmpty(){
	PasswordInput(password = "", onPasswordChange = {})
}