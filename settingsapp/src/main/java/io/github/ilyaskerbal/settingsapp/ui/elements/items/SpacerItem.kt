package io.github.ilyaskerbal.settingsapp.ui.elements.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.ilyaskerbal.settingsapp.ui.elements.SettingsItem

@Composable
fun SpacerItem(
	modifier: Modifier = Modifier,
	height: Dp = 48.dp,
	content: @Composable BoxScope.() -> Unit = {}
){
	SettingsItem(
		modifier = Modifier.fillMaxWidth()
	) {
		Box(
			modifier = Modifier
				.fillMaxWidth()
				.heightIn(height)
				.background(color = MaterialTheme.colors.onSurface.copy(alpha = 0.12f)),
			contentAlignment = Alignment.Center,
			content = content
		)
	}
}

@Preview
@Composable
private fun SpacerItemPreview() {
	SpacerItem()
}

@Preview
@Composable
private fun SpacerItemWithContentPreview() {
	SpacerItem(){
		Icon(imageVector = Icons.Filled.KeyboardArrowDown, contentDescription = null)
	}
}