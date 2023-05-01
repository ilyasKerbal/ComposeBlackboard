package io.github.ilyaskerbal.settingsapp

enum class ThemeOption(val index: Int) {
	SYSTEM(0),
	LIGHT(1),
	DARK(2);
	companion object {
		fun fromIndex(index: Int): ThemeOption = when(index) {
			0 -> SYSTEM
			1 -> LIGHT
			2 -> DARK
			else -> throw IllegalArgumentException("Invalid theme options")
		}
	}
}