package io.github.ilyaskerbal.navigationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import io.github.ilyaskerbal.navigationapp.screens.Home
import io.github.ilyaskerbal.navigationapp.ui.theme.ComposeBlackboardTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ComposeBlackboardTheme {
				Home()
			}
		}
	}
}