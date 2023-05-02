package io.github.ilyaskerbal.settingsapp.ui.elements.items

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.ilyaskerbal.settingsapp.MarketingOption
import io.github.ilyaskerbal.settingsapp.R
import io.github.ilyaskerbal.settingsapp.ui.elements.SettingsItem
import io.github.ilyaskerbal.settingsapp.ui.elements.Tags

@Composable
fun MarketingItem(
	modifier: Modifier = Modifier,
	@StringRes title: Int,
	currentOption: MarketingOption,
	onOptionChange: (Int) -> Unit = {}
){
	val options: Array<String> = stringArrayResource(id = R.array.marketing_options)

	SettingsItem(
		modifier = modifier
	) {
		Column(
			modifier = Modifier
				.fillMaxWidth()
				.padding(dimensionResource(id = R.dimen.item_padding))
		) {
			Text(
				text = stringResource(id = title)
			)
			options.forEachIndexed { index, option ->
				Row(
					modifier = Modifier
						.testTag(Tags.MARKETING_OPTION + index)
						.selectable(
							onClick = { onOptionChange(index) },
							selected = index == currentOption.index,
							role = Role.RadioButton
						)
						.fillMaxWidth()
						.padding(dimensionResource(id = R.dimen.option_row_padding))
				) {
					RadioButton(
						selected = index == currentOption.index,
						onClick = null
					)
					Text(
						modifier = Modifier.padding(start = dimensionResource(id = R.dimen.options_start_padding)),
						text = option
					)
				}
			}
		}
	}
}

@Preview
@Composable
private fun MarketingItemAcceptPreview() {
	MarketingItem(
		title = R.string.marketing_title,
		currentOption = MarketingOption.ACCEPT
	)
}

@Preview
@Composable
private fun MarketingItemRejectPreview() {
	MarketingItem(
		title = R.string.marketing_title,
		currentOption = MarketingOption.REJECT
	)
}