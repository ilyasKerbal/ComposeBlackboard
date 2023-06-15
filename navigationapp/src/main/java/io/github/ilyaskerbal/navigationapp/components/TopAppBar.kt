package io.github.ilyaskerbal.navigationapp.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import io.github.ilyaskerbal.navigationapp.R
import io.github.ilyaskerbal.navigationapp.utils.Destination
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TopAppBar(
	currentDestination: Destination,
	coroutineScope: CoroutineScope,
	scaffoldState: ScaffoldState
) {
	androidx.compose.material.TopAppBar(
		title = { Text(text = "Home") },
		actions = {
			val snackbarMessage = stringResource(id = R.string.not_available)
			if (currentDestination != Destination.Feed) {
				IconButton(onClick = {
					coroutineScope.launch {
						scaffoldState.snackbarHostState.showSnackbar(snackbarMessage)
					}
				}) {
					Icon(
						imageVector = Icons.Default.Info,
						contentDescription = stringResource(id = R.string.cd_more_information)
					)
				}
			}
		},
		navigationIcon = {
			IconButton(onClick = {
				coroutineScope.launch {
					scaffoldState.drawerState.open()
				}
			}) {
				Icon(
					imageVector = Icons.Default.Menu, contentDescription = stringResource(
						id = R.string.cd_open_navigation_drawer
					)
				)
			}
		}
	)
}