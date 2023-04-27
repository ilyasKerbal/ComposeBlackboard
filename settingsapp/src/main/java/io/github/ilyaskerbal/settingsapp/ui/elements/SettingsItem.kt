package io.github.ilyaskerbal.settingsapp.ui.elements

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import io.github.ilyaskerbal.settingsapp.R

@Composable
fun SettingsItem(
	modifier: Modifier = Modifier,
	content: @Composable () -> Unit
) {
	Surface(
		modifier = modifier
			.fillMaxWidth()
	) {
		content()
	}
}