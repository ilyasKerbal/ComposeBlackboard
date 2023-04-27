package io.github.ilyaskerbal.settingsapp.ui.elements

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.ilyaskerbal.settingsapp.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SettingsScreen() {
		Scaffold(
			scaffoldState = rememberScaffoldState(),
			topBar = {
				SettingsAppBar(title = R.string.app_title, navigation = {})
			}
		) {
			Surface(
				modifier = Modifier.fillMaxSize(),
				color = MaterialTheme.colors.background
			){
				SettingsList()
			}
		}
}