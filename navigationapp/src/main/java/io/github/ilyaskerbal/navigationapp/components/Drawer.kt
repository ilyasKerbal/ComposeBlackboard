package io.github.ilyaskerbal.navigationapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.ilyaskerbal.navigationapp.R
import io.github.ilyaskerbal.navigationapp.utils.Destination

@Composable
fun ColumnScope.DrawerContent(
	modifier: Modifier = Modifier,
	onNavigationSelected: (destination: Destination) -> Unit
) {
	Text(
		modifier = Modifier.padding(16.dp),
		text = stringResource(id = R.string.label_name),
		fontSize = 20.sp
	)
	Spacer(modifier = Modifier.height(8.dp))
	Text(
		modifier = Modifier.padding(16.dp),
		text = stringResource(id = R.string.label_email),
		fontSize = 16.sp
	)
	Divider (
		modifier = Modifier
			.fillMaxWidth()
			.padding(horizontal = 16.dp, vertical = 8.dp)
	)
	DrawerItem(
		label = Destination.Settings.title,
		icon = Destination.Settings.icon,
		onClick = { onNavigationSelected(Destination.Settings) }
	)
	Spacer(modifier = Modifier.height(8.dp))
	DrawerItem(
		label = Destination.Upgrade.title,
		icon = Destination.Upgrade.icon,
		onClick = { onNavigationSelected(Destination.Upgrade) }
	)
	Spacer(
		modifier = Modifier
			.weight(1f)
	)
	DrawerItem(
		label = stringResource(id = R.string.log_out),
		icon = Icons.Default.Close
	)
}


@Composable
fun DrawerItem(
	modifier: Modifier = Modifier,
	label: String,
	icon: ImageVector?,
	onClick: () -> Unit = {}
) {
	Row(
		modifier = modifier
			.fillMaxWidth()
			.clickable { onClick() }
			.padding(16.dp),
		verticalAlignment = Alignment.CenterVertically
	) {
		icon?.let {
			Icon(
				imageVector = it,
				contentDescription = null
			)
		}
		Spacer(modifier = Modifier.width(16.dp))
		Text(
			text =  label,
			fontWeight = FontWeight.Black
		)
	}
}

@Preview(showBackground = true)
@Composable
private fun PreviewDrawerItem() {
	DrawerItem(
		label = Destination.Settings.title,
		icon = Destination.Settings.icon
	)
}