package io.github.ilyaskerbal.settingsapp.ui.elements.items

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.tooling.preview.Preview
import io.github.ilyaskerbal.settingsapp.R
import io.github.ilyaskerbal.settingsapp.ui.elements.SettingsItem
import io.github.ilyaskerbal.settingsapp.ui.elements.Tags

@Composable
fun HintsItem(
	modifier: Modifier = Modifier,
	@StringRes title: Int,
	onToggle: (Boolean) -> Unit,
	state: Boolean
) {
	val itemStateDescription = if (state)
		stringResource(id = R.string.cd_hints_enabled)
	else stringResource(id = R.string.cd_hints_disabled)

	SettingsItem(
		modifier = modifier
	) {
		Row(
			modifier = Modifier
				.testTag(Tags.HINTS_TOGGLE)
				.toggleable(
					value = state,
					role = Role.Checkbox,
					onValueChange = onToggle
				)
				.semantics { stateDescription = itemStateDescription }
				.fillMaxWidth()
				.padding(dimensionResource(id = R.dimen.item_padding)),
			verticalAlignment = Alignment.CenterVertically
		) {
			Text(
				modifier = Modifier.weight(1f),
				text = stringResource(id = title)
			)
			Checkbox(
				checked = state,
				onCheckedChange = null
			)
		}
	}
}

@Preview
@Composable
private fun PreviewHintsItemDisabled() {
	HintsItem(title = R.string.hints_title, onToggle = {}, state = false)
}

@Preview
@Composable
private fun PreviewHintsItemEnabled() {
	HintsItem(title = R.string.hints_title, onToggle = {}, state = true)
}