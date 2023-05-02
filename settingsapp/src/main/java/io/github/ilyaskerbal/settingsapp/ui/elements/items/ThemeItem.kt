package io.github.ilyaskerbal.settingsapp.ui.elements.items

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.PopupProperties
import io.github.ilyaskerbal.settingsapp.R
import io.github.ilyaskerbal.settingsapp.ThemeOption
import io.github.ilyaskerbal.settingsapp.ui.elements.SettingsItem
import io.github.ilyaskerbal.settingsapp.ui.elements.Tags

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ThemeItem(
	modifier: Modifier = Modifier,
	@StringRes title: Int,
	currentOption: ThemeOption,
	onThemeChange: (Int) -> Unit = {}
){

	val themeOptions: Array<String> = stringArrayResource(id = R.array.theme_options)
	var expended: Boolean by remember { mutableStateOf(false) }

	SettingsItem(
		modifier = modifier.fillMaxWidth()
	) {
		Row(
			modifier = Modifier
				.testTag(Tags.THEME_ITEM)
				.clickable(
					onClick = { expended = true },
					onClickLabel = stringResource(id = R.string.cd_select_theme)
				)
				.fillMaxWidth()
				.padding(dimensionResource(id = R.dimen.item_padding))
		) {
			Text(
				text = stringResource(id = title),
				modifier = Modifier.weight(1f)
			)
			Box(modifier = Modifier) {
				Text(
					text = themeOptions[currentOption.index],
					style = LocalTextStyle.current.copy(fontWeight = FontWeight.Bold)
				)
				DropdownMenu(
					expanded = expended,
					onDismissRequest = { expended = false },
					properties = PopupProperties(usePlatformDefaultWidth = true),
					modifier = Modifier.testTag(Tags.THEME_POPUP_MENU)
				) {
					themeOptions.forEachIndexed { index, theme ->
						DropdownMenuItem(
							modifier = Modifier.testTag(Tags.THEME_OPTION + index),
							onClick = {
								onThemeChange(index)
								expended = false
							}
						) {
							Text(text = theme)
						}
					}
				}
			}
		}
	}
}

@Preview
@Composable
private fun ThemeItemPreview(){
	ThemeItem(
		title = R.string.theme_title,
		currentOption = ThemeOption.SYSTEM
	)
}