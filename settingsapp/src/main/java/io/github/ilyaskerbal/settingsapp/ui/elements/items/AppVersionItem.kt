package io.github.ilyaskerbal.settingsapp.ui.elements.items

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import io.github.ilyaskerbal.settingsapp.R
import io.github.ilyaskerbal.settingsapp.ui.elements.SettingsItem

@Composable
fun AppVersionItem(
	modifier: Modifier = Modifier,
	@StringRes title: Int,
	version: String,
) {
	SettingsItem(
		modifier = modifier.fillMaxWidth()
	) {
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(dimensionResource(id = R.dimen.item_padding))
		) {
			Text(
				text = stringResource(id = title),
				modifier = Modifier.weight(1f)
			)
			Text(text = version)
		}
	}
}

@Preview
@Composable
private fun AppVersionItemPreview() {
	AppVersionItem(
		title = R.string.version_title,
		version = "1.0.0"
	)
}