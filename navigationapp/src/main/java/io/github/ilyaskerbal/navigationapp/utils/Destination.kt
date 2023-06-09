package io.github.ilyaskerbal.navigationapp.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destination(
	val title: String,
	val icon: ImageVector? = null
) {
	object Home: Destination(title = "Home")
	object Calendar: Destination(title = "Calendar", icon = Icons.Default.DateRange)
	object Contacts: Destination(title = "Contacts", icon = Icons.Default.Person)
	object Feed: Destination(title = "Feed", icon = Icons.Default.List)
}