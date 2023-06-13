package io.github.ilyaskerbal.navigationapp.screens

import android.annotation.SuppressLint
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import io.github.ilyaskerbal.navigationapp.R
import io.github.ilyaskerbal.navigationapp.components.BottomNavigationBar
import io.github.ilyaskerbal.navigationapp.components.Navigation
import io.github.ilyaskerbal.navigationapp.utils.Destination

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Home(
	modifier: Modifier = Modifier
) {
	val scaffoldState = rememberScaffoldState()
	val navHostController = rememberNavController()
	Scaffold(
		modifier = modifier,
		scaffoldState = scaffoldState,
		topBar = {
			TopAppBar(title = {
				Text(text = "Home")
			})
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
				currentDestination = Destination.Feed,
				onNavigate = {}
			)
		}
	) {
		Navigation(
			modifier = modifier,
			navHostController = navHostController
		)
	}
}