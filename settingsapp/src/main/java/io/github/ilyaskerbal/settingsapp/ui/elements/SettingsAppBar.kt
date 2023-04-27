package io.github.ilyaskerbal.settingsapp.ui.elements

import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import io.github.ilyaskerbal.settingsapp.R

@Composable
fun SettingsAppBar(
	modifier: Modifier = Modifier,
	@StringRes title: Int,
	navigation: () -> Unit
) {
	TopAppBar(
		modifier = modifier,
		title = { Text(text = stringResource(id = title)) },
		backgroundColor = MaterialTheme.colors.surface,
		navigationIcon = {
			IconButton(onClick = navigation) {
				Icon(Icons.Filled.ArrowBack, contentDescription = stringResource(id = R.string.cd_back_button))
			}
		}
	)
}

@Preview(name = "Light theme preview")
@Composable
private fun SettingsAppBarPreview() {
	SettingsAppBar(
		title = R.string.app_title
	) {

	}
}

@Preview(name = "Dark theme preview", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun SettingsAppBarPreviewDark() {
	SettingsAppBar(
		title = R.string.app_title
	) {

	}
}