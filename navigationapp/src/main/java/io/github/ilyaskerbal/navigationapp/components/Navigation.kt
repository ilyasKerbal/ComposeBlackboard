package io.github.ilyaskerbal.navigationapp.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import io.github.ilyaskerbal.navigationapp.utils.Destination

@Composable
fun Navigation(
	modifier: Modifier = Modifier,
	navHostController: NavHostController
) {
	NavHost(
		modifier = modifier,
		navController = navHostController,
		startDestination = Destination.Feed.path
	) {
		composable(
			route = Destination.Feed.path
		) {
			ContentArea(
				destination = Destination.Feed,
				modifier = Modifier.fillMaxSize()
			)
		}
		composable(
			route = Destination.Contacts.path
		) {
			ContentArea(
				destination = Destination.Contacts,
				modifier = Modifier.fillMaxSize()
			)
		}
		composable(
			route = Destination.Calendar.path
		) {
			ContentArea(
				destination = Destination.Calendar,
				modifier = Modifier.fillMaxSize()
			)
		}
	}
}