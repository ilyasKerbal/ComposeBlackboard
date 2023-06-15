package io.github.ilyaskerbal.navigationapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.DrawerValue
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import io.github.ilyaskerbal.navigationapp.R
import io.github.ilyaskerbal.navigationapp.components.BottomNavigationBar
import io.github.ilyaskerbal.navigationapp.components.DrawerContent
import io.github.ilyaskerbal.navigationapp.components.Navigation
import io.github.ilyaskerbal.navigationapp.components.TopAppBar
import io.github.ilyaskerbal.navigationapp.utils.Destination
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Home(
	modifier: Modifier = Modifier
) {
	val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
	val scaffoldState = rememberScaffoldState(drawerState = drawerState)
	val navHostController = rememberNavController()
	val navBackStackEntry: State<NavBackStackEntry?> = navHostController.currentBackStackEntryAsState()
	val currentDestination: State<Destination> = remember(navBackStackEntry) {
		derivedStateOf {
			navBackStackEntry?.value?.destination?.route?.let { Destination.fromString(it) } ?: run { Destination.Home }
		}
	}
	val coroutineScope = rememberCoroutineScope()
	Scaffold(
		modifier = modifier,
		scaffoldState = scaffoldState,
		topBar = {
			TopAppBar(
				currentDestination = currentDestination.value,
				coroutineScope = coroutineScope,
				scaffoldState =  scaffoldState
			)
		},
		floatingActionButton = {
			FloatingActionButton(onClick = { /*TODO*/ }) {
				Icon(
					imageVector = Icons.Default.Add,
					contentDescription = stringResource(id = R.string.cd_create_item)
				)
			}
		},
		bottomBar = {
			BottomNavigationBar(
				currentDestination = currentDestination.value,
				onNavigate = {
					navHostController.navigate(it.path) {
						popUpTo(navHostController.graph.findStartDestination().id) {
							saveState = true
						}
						launchSingleTop = true
						restoreState = true
					}
				}
			)
		},
		drawerContent = {
			DrawerContent(
				onNavigationSelected = {
				   navHostController.navigate(it.path)
					coroutineScope.launch {
						drawerState.close()
					}
				},
				modifier = Modifier.fillMaxWidth()
			)
		}
	) {
		Navigation(
			modifier = modifier,
			navHostController = navHostController
		)
	}
}