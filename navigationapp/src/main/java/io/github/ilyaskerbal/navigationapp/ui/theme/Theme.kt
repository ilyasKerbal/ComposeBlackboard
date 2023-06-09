package io.github.ilyaskerbal.navigationapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorPalette = darkColors(
	primary = BrightGreen,
	primaryVariant = DarkGreen,
	secondary = Orange,
	background = MediumGray,
	onBackground = TextWhite,
	surface = LightGray,
	onSurface = TextWhite,
	onPrimary = Color.White,
	onSecondary = Color.White,
)

private val LightColorPalette = lightColors(
	primary = BrightGreen,
	primaryVariant = DarkGreen,
	secondary = Orange,
	background = Color.White,
	onBackground = DarkGray,
	surface = Color.White,
	onSurface = DarkGray,
	onPrimary = Color.White,
	onSecondary = Color.White,
)

@Composable
fun ComposeBlackboardTheme(
	darkTheme: Boolean = isSystemInDarkTheme(),
	// Dynamic color is available on Android 12+
	dynamicColor: Boolean = true,
	content: @Composable () -> Unit
) {
	val colorScheme = when {
		darkTheme -> DarkColorPalette
		else -> LightColorPalette
	}
	val view = LocalView.current
	if (!view.isInEditMode) {
		SideEffect {
			val window = (view.context as Activity).window
			window.statusBarColor = colorScheme.primary.toArgb()
			WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
		}
	}

	MaterialTheme(
		colors = colorScheme,
		typography = Typography,
		content = content
	)
}