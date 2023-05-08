package io.github.ilyaskerbal.authentication.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import io.github.ilyaskerbal.authentication.R

@Composable
fun AuthenticationErrorDialog(
    modifier: Modifier = Modifier,
    error: String,
    dismissError: () -> Unit,
){
	AlertDialog(
		modifier = modifier,
		onDismissRequest = dismissError,
		confirmButton = {
			Button(
				onClick = dismissError
			){
				Text(text = stringResource(id = R.string.error_action))
			}
		},
		title = {
				Text(
					text = stringResource(id = R.string.error_title)
				)
		},
		text = {
			Text(
				text = error
			)

		}
	)
}

@Preview
@Composable
private fun AuthenticationErrorDialogPreview() {
	AuthenticationErrorDialog(
		error = "Something went wrong!",
		dismissError = {}
	)
}