package io.github.ilyaskerbal.settingsapp.ui.elements.items

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import io.github.ilyaskerbal.settingsapp.R
import io.github.ilyaskerbal.settingsapp.ui.elements.SettingsItem

@Composable
fun SubscriptionItem(
	modifier: Modifier = Modifier,
	@StringRes title: Int,
	onClick: () -> Unit = {}
){
	SettingsItem(
		modifier = modifier
	) {
		Row(
			modifier = Modifier
				.clickable(
					onClickLabel = stringResource(id = R.string.cd_subscription_click),
					onClick = onClick,
				)
				.fillMaxWidth()
				.padding(dimensionResource(id = R.dimen.item_padding)),
			verticalAlignment = Alignment.CenterVertically
		) {
			Text(
				text = stringResource(id = title),
				modifier = Modifier.weight(1f)
			)
			Icon(
				imageVector = Icons.Filled.KeyboardArrowRight,
				contentDescription = null
			)

		}
	}
}

@Preview
@Composable
private fun SubscriptionItemPreview() {
	SubscriptionItem(
		title = R.string.subscription_title
	)
}