package io.github.ilyaskerbal.settingsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.ilyaskerbal.settingsapp.ui.elements.SettingsScreen
import io.github.ilyaskerbal.settingsapp.ui.theme.ComposeBlackboardTheme

class SettingsActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ComposeBlackboardTheme {
				// A surface container using the 'background' color from the theme
				SettingsScreen()
			}
		}
	}
}