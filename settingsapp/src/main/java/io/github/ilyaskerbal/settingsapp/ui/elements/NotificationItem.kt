package io.github.ilyaskerbal.settingsapp.ui.elements

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import io.github.ilyaskerbal.settingsapp.R

@Composable
fun NotificationIem(
	modifier: Modifier = Modifier,
	@StringRes title: Int,
	onToggle: (Boolean) -> Unit = {},
	state: Boolean
) {
	SettingsItem(modifier = modifier) {
		Row(
			modifier = Modifier.fillMaxWidth()
				.padding(horizontal = dimensionResource(id = R.dimen.item_padding)),
			verticalAlignment = Alignment.CenterVertically
		) {
			Text(
				modifier = Modifier.weight(1f),
				text = stringResource(id = title)
			)
			Switch(checked = state, onCheckedChange = onToggle)
		}
	}
}

@Preview
@Composable
private fun NotificationIemPreviewTrue() {
	NotificationIem(title = R.string.notification_title, state = true)
}

@Preview
@Composable
private fun NotificationIemPreviewFalse() {
	NotificationIem(title = R.string.notification_title, state = false)
}