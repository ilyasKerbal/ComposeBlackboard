package io.github.ilyaskerbal.navigationapp.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destination(
	val title: String,
	val path: String,
	val icon: ImageVector? = null
) {
	object Home: Destination(title = "Home", path = "home")
	object Calendar: Destination(title = "Calendar", path = "calendar", icon = Icons.Default.DateRange)
	object Contacts: Destination(title = "Contacts", path = "contacts", icon = Icons.Default.Person)
	object Feed: Destination(title = "Feed", path = "feed",icon = Icons.Default.List)

	object Settings: Destination(title = "Settings", path = "settings", icon = Icons.Default.Settings)
	object Upgrade: Destination(title = "Upgrade", path = "upgrade", icon = Icons.Default.Star)

	companion object {
		fun fromString(value: String): Destination = when(value) {
			Feed.path -> Feed
			Calendar.path -> Calendar
			Contacts.path -> Contacts
			Settings.path -> Settings
			Upgrade.path -> Upgrade
			else -> Home
		}
	}
}