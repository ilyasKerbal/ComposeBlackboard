package io.github.ilyaskerbal.settingsapp.ui.elements

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.tooling.preview.Preview
import io.github.ilyaskerbal.settingsapp.R

@Composable
fun NotificationItem(
	modifier: Modifier = Modifier,
	@StringRes title: Int,
	onToggle: (Boolean) -> Unit = {},
	state: Boolean
) {
	val stateDescription = if (state)
		stringResource(id = R.string.cd_notifications_enabled)
	else stringResource(id = R.string.cd_notifications_disabled)

	SettingsItem(modifier = modifier) {
		Row(
			modifier = Modifier
				.toggleable(
					value = state,
					role = Role.Switch,
					onValueChange = onToggle
				)
				.semantics {
					this.stateDescription = stateDescription
				}
				.fillMaxWidth()
				.padding(dimensionResource(id = R.dimen.item_padding)),
			verticalAlignment = Alignment.CenterVertically
		) {
			Text(
				modifier = Modifier.weight(1f),
				text = stringResource(id = title)
			)
			Switch(checked = state, onCheckedChange = null)
		}
	}
}

@Preview
@Composable
private fun NotificationIemPreviewTrue() {
	NotificationItem(title = R.string.notification_title, state = true)
}

@Preview
@Composable
private fun NotificationIemPreviewFalse() {
	NotificationItem(title = R.string.notification_title, state = false)
}