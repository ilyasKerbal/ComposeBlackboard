package io.github.ilyaskerbal.navigationapp.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.ilyaskerbal.navigationapp.utils.Destination

@Composable
fun BottomNavigationBar(
	modifier: Modifier = Modifier,
	currentDestination: Destination,
	onNavigate: (destination: Destination) -> Unit
) {
	BottomNavigation(
		modifier = modifier
	) {
		listOf<Destination>(
			Destination.Feed,
			Destination.Contacts,
			Destination.Calendar
		).forEach {
			BottomNavigationItem(
				selected = it.path == currentDestination.path,
				onClick = { onNavigate(it) },
				icon = {
					it.icon?.let { icon ->
						Icon(imageVector = icon, contentDescription = it.title)
					}
				},
				label = {
					Text(text = it.title)
				}
			)
		}
	}
}